package com.fsgame.server.encoder;

import com.fsgame.facade.FSCommonLib;
import com.fsgame.mode.FSMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author sunweidong
 * @category 编码器
 * 1、消息编码器
 * 2、消息 = 消息头部 + 消息实体
 * 3、消息头部 = 4字节消息实体长度 + 4字节消息类型ID
 * 4、消息实体为Bytes类型字节数组
 * 5、Message消息对象转化成二进制字节流传输
 */
public class CustomProtobufEncoder extends MessageToByteEncoder<FSMessage> {
    @Override
    protected void encode(ChannelHandlerContext ctx, FSMessage msg, ByteBuf out) throws Exception {
        if(msg == null || msg.getHeader() == null){
            throw new Exception("the encode message is null");
        }

        byte[] msgLenBytes = FSCommonLib.Int2String(msg.getHeader().getLength()).getBytes();
        
        byte[] msgTypeBytes = msg.getHeader().getMsgType().getBytes();
        
        byte[] dataBytes = msg.getData();
        
        byte[] msgBytes = new byte[msgLenBytes.length + msgTypeBytes.length + dataBytes.length];
        
        System.arraycopy(msgLenBytes, 0, msgBytes, 0, msgLenBytes.length);
        System.arraycopy(msgTypeBytes, 0, msgBytes, msgLenBytes.length, msgTypeBytes.length);
        System.arraycopy(dataBytes, 0, msgBytes, msgLenBytes.length + msgTypeBytes.length, dataBytes.length);

        if(msgBytes != null){
        	//写入message
            out.writeBytes(msgBytes);
        }
    }
}