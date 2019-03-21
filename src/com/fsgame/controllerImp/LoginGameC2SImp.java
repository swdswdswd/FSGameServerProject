/**
 * 
 */
package com.fsgame.controllerImp;

import com.fsgame.dao.MySQLDBHelper;
import com.fsgame.db.FSPlayerInfo;
import com.fsgame.facade.FSCommonLib;
import com.fsgame.facade.FSGameObject;
import com.fsgame.message.interfaces.MessageInterface;
import com.fsgame.mode.FSMessage;
import com.fsgame.mode.MessageHeader;
import com.fsgame.proto.MSGBaseCommon.LoginState;
import com.fsgame.proto.MSGLoginGameC2S.LoginGameC2S;
import com.fsgame.proto.MSGLoginGameS2C.LoginGameS2C;
import com.google.protobuf.InvalidProtocolBufferException;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;

/**
 *@author sunweidong
 *@category 处理客户端登录请求
 *@version 2019年3月1日19:36:48
 */
public class LoginGameC2SImp implements MessageInterface{
	private ChannelHandlerContext ctx;
	private LoginGameC2S msgread = null;
	private boolean flag = false;
	private FSPlayerInfo playerInfo = null;
	
	@Override
	public void readMessage(byte[] msgs, ChannelHandlerContext ctx) throws InvalidProtocolBufferException {
		this.ctx =ctx;
		msgread = LoginGameC2S.parseFrom(msgs);
		playerInfo = MySQLDBHelper.loginGame(msgread.getUsername(), msgread.getPassword());
		if(playerInfo != null) {
			flag = true;
			writeMessage();
		}else {
			writeMessage();
		}
	}

	@Override
	public void writeMessage() {
		FSMessage message = new FSMessage();
		LoginGameS2C.Builder msg = LoginGameS2C.newBuilder();
		if (flag) {
			msg.setState(LoginState._SUCESSED_);
		}else {
			msg.setState(LoginState._SUCESSED_);
		}
		
		//添加玩家信息到服务器
		playerAddToServer(playerInfo);
		
		LoginGameS2C msgTemp = msg.build();
		
		byte[] bytes = msgTemp.toByteArray();
		
		message.setData(bytes);
		
		MessageHeader header = new MessageHeader();
		String MsgTypeStr = FSCommonLib.getKey(LoginGameS2C.class.toString());
		header.setLength(bytes.length);
		header.setMsgType(MsgTypeStr);
		message.setHeader(header);
		ctx.writeAndFlush(message);
		
	}
	
	private void playerAddToServer(FSPlayerInfo playerInfo) {
		
		//将session id加入玩家客户端列表
		Integer key = playerInfo.getPlayerBaseId();
		ChannelId value = ctx.channel().id();
		
		//客户端数据在服务器存储下来
		FSGameObject.Clients.put(key, value);
		FSGameObject.PlayerExtents.put(key, playerInfo);
	}

}
