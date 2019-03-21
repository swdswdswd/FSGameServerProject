package com.fsgame.server.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

import com.fsgame.facade.FSCommonLib;
import com.fsgame.mode.FSMessage;
import com.fsgame.mode.MessageHeader;

/**
 * @author sunweidong
 *@category 解码器
 * 1、接收消息解码器
 * 2、消息 = 消息头部 + 消息实体
 * 3、消息头部 = 4字节消息实体长度 + 4字节消息类型ID
 * 4、消息实体为Bytes类型字节数组
 */
public class CustomProtobufDecoder extends ByteToMessageDecoder {
	
    private int MIN_LENGTH = 8;
    private int MAX = 2048;
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if(in.readableBytes() <= MIN_LENGTH){
            return;
        }
        if(in.readableBytes() > MAX){
            in.skipBytes(in.readableBytes());
        }
        int b = in.readableBytes();
        
        
        in.markReaderIndex();
        FSMessage message = new FSMessage();
        
        MessageHeader header = new MessageHeader();
        //设置消息体长度
        byte[] len = new byte[4];
        in.readBytes(len);
        String LenStr = new String(len);
        int length = Integer.parseInt(LenStr);
        header.setLength(length);
        
        //设置消息类型
        byte[] msgType = new byte[4];
        in.readBytes(msgType);
        String MsgType = new String(msgType);
        
        String MsgTypeClassName = FSCommonLib.ProtocolMap.get(MsgType);
        
        header.setMsgTypeClassName(MsgTypeClassName);
        
        header.setMsgType(MsgType);
        
        message.setHeader(header);
        
        byte[] bytes = new byte[length];
        
        if(length > 0){
            if(in.readableBytes() < length){
                //包还没齐，返回
            	int a = in.readableBytes();
                in.resetReaderIndex();
                return;
            }
         
            in.readBytes(bytes);
            message.setData(bytes);
        }
        out.add(message);
        return ;
    }
}