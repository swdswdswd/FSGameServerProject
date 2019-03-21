package com.fsgame.server;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fsgame.facade.FSGameObject;
import com.fsgame.server.group.FSChannelGroups;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author sunweidong
 * 1、单个客户端服务器线程逻辑代码
 * 2、通过反射动态创建消息 并调用初始化的方法
 * */
public class FSGameNettyServerHandler extends ChannelHandlerAdapter {
	
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
	@Override
	public void channelRead(final ChannelHandlerContext ctx, Object msg) {

		com.fsgame.mode.FSMessage msgs = (com.fsgame.mode.FSMessage)msg;
            // 根据给定的类名初始化类
            Class<?> msgClass;
				try {
					System.out.println(SDF.format(new Date()) + "Receive message form ChannelId: [" + ctx.channel().id() + 
							"] ClientID: [" + FSGameObject.findClientID(ctx.channel().id())+ "] " +
							"MsgType: [" + msgs.getHeader().getMsgTypeClassName() + "] MsgBufferSize: [" + msgs.getHeader().getLength() +"]"
							);
					msgClass = Class.forName(msgs.getHeader().getMsgTypeClassName());
					Object obj = msgClass.newInstance();
					msgClass.getMethod("readMessage",byte[].class ,ChannelHandlerContext.class).invoke(obj, msgs.getData(),ctx);

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}catch (InstantiationException e) {
					e.printStackTrace();
				} 
	}
	
//	@Override
//	@Skip
//	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//		cause.printStackTrace();
//		ctx.close();
//	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Channel ch = ctx.channel();
		 System.out.println("channelActive=>IP:[" + ch.remoteAddress().toString().substring(1) + "] LocalTime[" + SDF.format(new Date()) + "]");
//        System.out.println(ctx.channel().remoteAddress() + "上线了\n");
        FSChannelGroups.add(ch);
	}
	
	
	 @Override
	 public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
	     ctx.flush();
	 }
	    
	@Override
	public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
		System.out.println(String.format(" close  client(%s) close sucess", ctx.channel().localAddress().toString().substring(1)));
	}

	@Override
	public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
		System.out.println(String.format("disconnect  client(%s) close sucess", ctx.channel().localAddress().toString().substring(1)));
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "下线了\n");
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		System.out.println("server 推送的消息："+ ctx.channel().remoteAddress() + "注册进了服务器\n");
	}
	
	/**
	 * @author sunweidong
	 * @category 断开链接
	 * 1、 需要移除服务器数据
	 * 2、 存储数据到数据库
	 * */
	@Override
	 public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
//		 //用户下线的操作
		FSGameObject.removePlayerInfoFromClient(ctx);
		ctx.close();
		System.out.println(String.format("client(%s) close sucess", ctx.channel().localAddress().toString().substring(1)));
		System.out.println("server 推送的消息："+ ctx.channel().remoteAddress() + "离开了服务器\n");
	 }

	/**
	 * @author sunweidong
	 * @category 服务端心跳机制
	 *  1、客户端长时间未发送心跳包给服务端  表示客户端已经断开 断开该连接
	 * */
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if(FSChannelGroups.size() != 0) {
			System.out.println("20秒未收到客户端的消息，客户端异常！");
			if (evt instanceof IdleStateEvent){
	            IdleStateEvent event = (IdleStateEvent)evt;
	            if (event.state()== IdleState.READER_IDLE){
	                System.out.println("关闭客户端！");
	                FSGameObject.removePlayerInfoFromClient(ctx);
	                FSChannelGroups.discard(ctx.channel());
	                ctx.channel().close();
	            }
	        }else {
	            super.userEventTriggered(ctx,evt);
	        }
		}
	}
	
}