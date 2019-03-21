package com.fsgame.message.interfaces;

import com.google.protobuf.InvalidProtocolBufferException;

import io.netty.channel.ChannelHandlerContext;
/**
 * 1、所有的消息都必须实现此接口
 * 2、read提供读消息  初始化Message
 * 3、writeMessage处理消息 向客户端反馈消息
 * 4、后续需要再补充
 * */
public interface MessageInterface {
	public void readMessage(byte[] msgs,ChannelHandlerContext ctx) throws InvalidProtocolBufferException;
	public void writeMessage();
}
