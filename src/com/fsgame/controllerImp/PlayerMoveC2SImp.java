/**
 * 
 */
package com.fsgame.controllerImp;

import java.util.Iterator;

import com.fsgame.db.FSPlayerInfo;
import com.fsgame.facade.FSCommonLib;
import com.fsgame.facade.FSGameObject;
import com.fsgame.message.interfaces.MessageInterface;
import com.fsgame.mode.FSMessage;
import com.fsgame.mode.MessageHeader;
import com.fsgame.proto.MSGBaseCommon.MoveType;
import com.fsgame.proto.MSGPlayerMoveC2S.PlayerMoveC2S;
import com.fsgame.proto.MSGPlayerMoveS2C.PlayerMoveS2C;
import com.fsgame.server.group.FSChannelGroups;
import com.google.protobuf.InvalidProtocolBufferException;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author sunweidong
 *
 */
public class PlayerMoveC2SImp implements MessageInterface{
	private ChannelHandlerContext ctx;
	private PlayerMoveC2S msgread = null;
	@Override
	public void readMessage(byte[] msgs, ChannelHandlerContext ctx) throws InvalidProtocolBufferException {
		this.ctx =ctx;
		msgread = PlayerMoveC2S.parseFrom(msgs);
		FSPlayerInfo Player = FSGameObject.PlayerExtents.get(msgread.getMovebase().getBaseid());
		Player.setPlayerBaseId(msgread.getMovebase().getBaseid());
		Player.setPlayerName(msgread.getMovebase().getName());
		Player.setX(msgread.getMovebase().getCoor().getX());
		Player.setY(msgread.getMovebase().getCoor().getY());
		Player.setZ(msgread.getMovebase().getCoor().getZ());
		Player.setO(msgread.getMovebase().getCoor().getO());
		//overrid server data
		FSGameObject.PlayerExtents.put(msgread.getMovebase().getBaseid(), Player);
//		System.out.println("sffffffffffffffffffffffffff====");
		writeMessage();
	}

	@Override
	public void writeMessage() {
		PlayerMoveS2C.Builder resp = PlayerMoveS2C.newBuilder();
		resp.setMovebase(msgread.getMovebase());
		resp.setMoveop(msgread.getMoveop());
		FSMessage message = new FSMessage();
		PlayerMoveS2C msg = resp.build();
		
		byte[] bytes = msg.toByteArray();
		
		message.setData(bytes);
		
		MessageHeader header = new MessageHeader();
		String MsgTypeStr = FSCommonLib.getKey(PlayerMoveS2C.class.toString());
		header.setLength(bytes.length);
		header.setMsgType(MsgTypeStr);
		message.setHeader(header);
		//发送消息通知其他所有客户端
		FSGameObject.sendMsgToOtherClient(message,ctx);
		
	}

}
