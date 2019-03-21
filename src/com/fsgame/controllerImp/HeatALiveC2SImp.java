/**
 * 
 */
package com.fsgame.controllerImp;

import com.fsgame.facade.FSCommonLib;
import com.fsgame.facade.FSGameObject;
import com.fsgame.message.interfaces.MessageInterface;
import com.fsgame.mode.FSMessage;
import com.fsgame.mode.MessageHeader;
import com.fsgame.proto.MSGHeatALiveC2S.HeatALiveC2S;
import com.fsgame.proto.MSGHeatALiveS2C.HeatALiveS2C;
import com.google.protobuf.InvalidProtocolBufferException;

import io.netty.channel.ChannelHandlerContext;

/**
 * @author sunweidong
 *@category 服务器接收心跳包
 */
public class HeatALiveC2SImp implements MessageInterface{
	private ChannelHandlerContext ctx;
	@SuppressWarnings("unused")
	private HeatALiveC2S msgread = null;
	@Override
	public void readMessage(byte[] msgs, ChannelHandlerContext ctx) throws InvalidProtocolBufferException {
		this.ctx = ctx;
		msgread = HeatALiveC2S.parseFrom(msgs);
		//这里后期需要做一个时间戳的运算 判断客户端时间 
		
	//	writeMessage();
	}

	@Override
	public void writeMessage() {
		//服务端回应客户端消息
		HeatALiveS2C.Builder resp = HeatALiveS2C.newBuilder();
		resp.setTime(1.0f);
		
		FSMessage message = new FSMessage();
		HeatALiveS2C msg = resp.build();
		
		byte[] bytes = msg.toByteArray();
		
		message.setData(bytes);
		
		MessageHeader header = new MessageHeader();
		String MsgTypeStr = FSCommonLib.getKey(HeatALiveS2C.class.toString());
		header.setLength(bytes.length);
		header.setMsgType(MsgTypeStr);
		message.setHeader(header);
		
		ctx.writeAndFlush(message);
		//服务端同步数据  GameObjects
		FSGameObject.updatePlayerToClientObject(ctx.channel().id(),ctx);
	}

}
