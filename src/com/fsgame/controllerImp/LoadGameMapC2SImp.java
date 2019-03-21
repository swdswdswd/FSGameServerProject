/**
 * 
 */
package com.fsgame.controllerImp;

import java.util.Iterator;
import java.util.Map.Entry;

import com.fsgame.db.FSPlayerInfo;
import com.fsgame.facade.FSCommonLib;
import com.fsgame.facade.FSGameObject;
import com.fsgame.facade.ClientGameObject;
import com.fsgame.message.interfaces.MessageInterface;
import com.fsgame.mode.FSMessage;
import com.fsgame.mode.MessageHeader;
import com.fsgame.proto.MSGBaseCommon.Coordinate;
import com.fsgame.proto.MSGLoadGameMapC2S.LoadGameMapC2S;
import com.fsgame.proto.MSGLoadGameMapS2C.LoadGameMapS2C;
import com.fsgame.proto.MSGPlayerCommon.PlayerCommon;
import com.google.protobuf.InvalidProtocolBufferException;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;

/**
 * @author sunweidong
 *@category 加载玩家地图
 */
public class LoadGameMapC2SImp implements MessageInterface{
	private ChannelHandlerContext ctx;
	private LoadGameMapC2S msgread = null;
	private FSPlayerInfo playerInfo = null;
	
	@Override
	public void readMessage(byte[] msgs, ChannelHandlerContext ctx) throws InvalidProtocolBufferException {
		this.ctx =ctx;
		msgread = LoadGameMapC2S.parseFrom(msgs);
		writeMessage();
	}

	@Override
	public void writeMessage() {
		
		Integer PlayerID = FSGameObject.findClientID(ctx.channel().id());
		
		//获取玩家对象
		playerInfo = FSGameObject.PlayerExtents.get(PlayerID);
		
		LoadGameMapS2C.Builder resp = LoadGameMapS2C.newBuilder();
		
		PlayerCommon.Builder player = PlayerCommon.newBuilder();
		
		Coordinate.Builder coor = Coordinate.newBuilder();
		coor.setX(playerInfo.getX());
		coor.setY(playerInfo.getY());
		coor.setZ(playerInfo.getZ());
		coor.setO(playerInfo.getO());
		coor.setMap(playerInfo.getMapId());
		
		player.setHp(playerInfo.getHp());
		player.setBaseid(playerInfo.getPlayerBaseId());
		player.setName(playerInfo.getPlayerName());
		player.setCoor(coor.build());
		
		
		resp.setMainplayer(player.build());
		
		FSMessage message = new FSMessage();
		LoadGameMapS2C msg = resp.build();
		
		byte[] bytes = msg.toByteArray();
		
		message.setData(bytes);
		
		MessageHeader header = new MessageHeader();
		String MsgTypeStr = FSCommonLib.getKey(LoadGameMapS2C.class.toString());
		header.setLength(bytes.length);
		header.setMsgType(MsgTypeStr);
		message.setHeader(header);
		
		ctx.writeAndFlush(message);
		
		//广播自身信息
		FSGameObject.broadCastSelfEnterToAllClient(player,ctx.channel().id());
		
		//将其他客户端玩家同步过来
		ClientGameObject ClientObject = new ClientGameObject();
		FSGameObject.addPlayerToClientObject(ClientObject, PlayerID);
		FSGameObject.clientGameObjects.put(PlayerID, ClientObject);
		//发送消息进行同步
		FSGameObject.sendGameObjectToClient(ctx,ClientObject);
		
	}
	
}
