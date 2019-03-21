package com.fsgame.server;

import java.util.concurrent.TimeUnit;

import com.fsgame.facade.FSCommonLib;
import com.fsgame.server.decoder.CustomProtobufDecoder;
import com.fsgame.server.encoder.CustomProtobufEncoder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;

/**
 * @author sunweidong
 * @category netty服务器服务端线程
 * */
public class FSGameNettyServerBootstrap {
	private int port;

	public FSGameNettyServerBootstrap(int port) {
		this.port = port;
		bind();
	}

	private void bind() {
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(boss, worker);
			bootstrap.channel(NioServerSocketChannel.class);
			bootstrap.option(ChannelOption.SO_BACKLOG, 1024); // 连接数
			bootstrap.option(ChannelOption.TCP_NODELAY, true); // 不延迟，消息立即发送
			bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true); // 长连接
			bootstrap.handler(new LoggingHandler(LogLevel.INFO));
			bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel socketChannel) throws Exception {
					ChannelPipeline ch = socketChannel.pipeline();
					ch.addLast(new IdleStateHandler(20,0,0, TimeUnit.SECONDS));
					//
					ch.addLast("decoder",new CustomProtobufDecoder());
					ch.addLast("encoder",new CustomProtobufEncoder());
					
					ch.addLast(new FSGameNettyServerHandler());
					
//					ch.addLast(
//                            new TimeServerHandler(),
//                            new WriteTimeoutHandler(10),
//                            //控制写入超时10秒构造参数10表示如果持续10秒钟都没有数据写了，那么就超时。
//                            new ReadTimeoutHandler(10)
//                    );
				}
			});
			ChannelFuture f = bootstrap.bind(port).sync();
			if (f.isSuccess()) {
				System.err.println("启动Netty服务成功，端口号：" + this.port);
//				System.out.println("启动Netty服务成功，端口号：" + this.port);
			}
			// 关闭连接
			f.channel().closeFuture().sync();

		} catch (Exception e) {
			System.err.println("启动Netty服务异常，异常信息：" + e.getMessage());
			e.printStackTrace();
		} finally {
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		FSGameNettyServerBootstrap server = new FSGameNettyServerBootstrap(9998);
		new FSCommonLib();
	}
}