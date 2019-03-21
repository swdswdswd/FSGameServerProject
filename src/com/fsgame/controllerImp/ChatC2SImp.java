/**
 * 
 */
package com.fsgame.controllerImp;

import com.fsgame.facade.FSCommonLib;
import com.fsgame.facade.FSGameObject;
import com.fsgame.message.interfaces.MessageInterface;
import com.fsgame.mode.FSMessage;
import com.fsgame.mode.MessageHeader;
import com.fsgame.proto.MSGChatC2S.ChatC2S;
import com.fsgame.proto.MSGChatS2C.ChatS2C;
import com.google.protobuf.InvalidProtocolBufferException;

import io.netty.channel.ChannelHandlerContext;

/**
 * @author sunweidong
 * @category 聊天信息请求与转发
 */
public class ChatC2SImp implements MessageInterface {
	
	private ChannelHandlerContext ctx;
	private ChatC2S msgread = null;
	
	
	@Override
	public void readMessage(byte[] msgs, ChannelHandlerContext ctx) throws InvalidProtocolBufferException {
		this.ctx =ctx;
		msgread = ChatC2S.parseFrom(msgs);
		writeMessage();
	}

	@Override
	public void writeMessage() {
		FSMessage message = new FSMessage();
		ChatS2C.Builder msg = ChatS2C.newBuilder();
		
		msg.setType(msgread.getType());
		msg.setPlayerid(msgread.getPlayerid());
		msg.setMsg(msgread.getMsg());
		
		ChatS2C msgTemp = msg.build();
		
		byte[] bytes = msgTemp.toByteArray();
		
		message.setData(bytes);
		
		MessageHeader header = new MessageHeader();
		String MsgTypeStr = FSCommonLib.getKey(ChatS2C.class.toString());
		header.setLength(bytes.length);
		header.setMsgType(MsgTypeStr);
		message.setHeader(header);
		
		FSGameObject.sendMsgToOtherClient(message, ctx);
	}

}
