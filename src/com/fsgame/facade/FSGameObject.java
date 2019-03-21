/**
 * 
 */
package com.fsgame.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.fsgame.dao.MySQLDBHelper;
import com.fsgame.db.FSPlayerInfo;
import com.fsgame.mode.FSMessage;
import com.fsgame.mode.MessageHeader;
import com.fsgame.proto.MSGObjectCommon.ObjectSync;
import com.fsgame.proto.MSGObjectSyncS2C.ObjectSyncS2C;
import com.fsgame.proto.MSGPlayerCommon.PlayerCommon;
import com.fsgame.server.group.FSChannelGroups;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;

/**
 * @author sunweidong
 *@category 该对象声明游戏中的所有物体 以玩家世界为单位  提供所有游戏对象的操作接口
 *@version 2019年3月1日13:31:41
 */
public class FSGameObject {
	//存储所有的游戏客户端
	public static Map<Integer, ChannelId> Clients = new HashMap<Integer, ChannelId>();
	
	//存储服务器所有的客户端object
	public static Map<Integer, ClientGameObject> clientGameObjects = new HashMap<Integer, ClientGameObject>();

	//已经存在的玩家信息
	public static Map<Integer, FSPlayerInfo> PlayerExtents = new HashMap<Integer, FSPlayerInfo>();
	
	//离开的玩家信息
	public static ArrayList<Integer> PlayerLeaves = new ArrayList<>();
	
	
	/**
	 * @author sunweidong 
	 * @category 根据channel的ID查找对应的session
	 * */
	public static Integer findClientID(ChannelId id) {
		Iterator<Entry<Integer, ChannelId>> entries = Clients.entrySet().iterator();
		while (entries.hasNext()) {
			 
		    Entry<Integer, ChannelId> entry = entries.next();
		    //找到客户端
		    if(entry.getValue() == id) {
		    	return entry.getKey();
		    }
		}
		return null;
	}
	/**
	 * @author sunweidong
	 * @category 同步自身加入游戏地图信息给其他所有玩家
	 * */
	public static void broadCastSelfEnterToAllClient(PlayerCommon.Builder playerSelf, ChannelId id) {
		ObjectSyncS2C.Builder ObjectSyncs = ObjectSyncS2C.newBuilder();
		ObjectSync.Builder object = ObjectSync.newBuilder();
		object.setPlayerbase(playerSelf);
		ObjectSyncs.addEnter(object);
		FSMessage message = new FSMessage();
		
		ObjectSyncS2C msgTemp = ObjectSyncs.build();
		
		byte[] bytes = msgTemp.toByteArray();
		
		message.setData(bytes);
		
		MessageHeader header = new MessageHeader();
		String MsgTypeStr = FSCommonLib.getKey(ObjectSyncS2C.class.toString());
		header.setLength(bytes.length);
		header.setMsgType(MsgTypeStr);
		message.setHeader(header);
		
		Iterator<Channel> Channels = FSChannelGroups.CHANNEL_GROUP.iterator();
		while (Channels.hasNext()) {
		    Channel entry = Channels.next();
		    //给不是本机客户端发消息
		    if(entry.id() != id) {
		    	entry.writeAndFlush(message);
		    }
		}
	}
	
	/**
	 * @author sunweidong
	 * @category 同步自身离开游戏地图信息给其他所有玩家
	 * */
	public static void broadCastSelfLeaveToAllClient(Integer playerID, ChannelId id) {
		ObjectSyncS2C.Builder ObjectSyncs = ObjectSyncS2C.newBuilder();
		ObjectSyncs.addLeave(playerID);
		
		FSMessage message = new FSMessage();
		
		ObjectSyncS2C msgTemp = ObjectSyncs.build();
		
		byte[] bytes = msgTemp.toByteArray();
		
		message.setData(bytes);
		
		MessageHeader header = new MessageHeader();
		String MsgTypeStr = FSCommonLib.getKey(ObjectSyncS2C.class.toString());
		header.setLength(bytes.length);
		header.setMsgType(MsgTypeStr);
		message.setHeader(header);
		
		Iterator<Channel> Channels = FSChannelGroups.CHANNEL_GROUP.iterator();
		while (Channels.hasNext()) {
		    Channel entry = Channels.next();
		    //给不是本机客户端发消息
		    if(entry.id() != id) {
		    	entry.writeAndFlush(message);
		    }
		}
	}
	
	/**
	 * @author sunweidong
	 * @category 将服务器端的客户端object同步过去
	 * */
	public static void sendGameObjectToClient(ChannelHandlerContext ctx, ClientGameObject ClientObject) {
		ObjectSyncS2C.Builder ObjectSyncs = ObjectSyncS2C.newBuilder();
		
		//进入列表
		Iterator<Entry<Integer, FSPlayerInfo>> Enters = ClientObject.PlayerEnters.entrySet().iterator();
		while (Enters.hasNext()) {
			Entry<Integer, FSPlayerInfo> entry = Enters.next();
			ObjectSync.Builder object = ObjectSync.newBuilder();
			object.setPlayerbase(FSCommonLib.createPlayerPBObject(entry.getValue()));
			ObjectSyncs.addEnter(object);
		}
		
		//同步列表
		Iterator<Entry<Integer, FSPlayerInfo>> Extents = ClientObject.PlayerExtents.entrySet().iterator();
		while (Extents.hasNext()) {
		    Entry<Integer, FSPlayerInfo> entry = Extents.next();
		    ObjectSync.Builder object = ObjectSync.newBuilder();
			object.setPlayerbase(FSCommonLib.createPlayerPBObject(entry.getValue()));
			ObjectSyncs.addObjects(object);
		}
		
		//离开列表
		for(int i = 0; i < ClientObject.PlayerLeaves.size() ; ++i) {
			ObjectSyncs.addLeave(ClientObject.PlayerLeaves.get(i));
		}
		
		//创建消息
		FSMessage message = new FSMessage();
		
		ObjectSyncS2C msgTemp = ObjectSyncs.build();
		
		byte[] bytes = msgTemp.toByteArray();
		
		message.setData(bytes);
		
		MessageHeader header = new MessageHeader();
		String MsgTypeStr = FSCommonLib.getKey(ObjectSyncS2C.class.toString());
		header.setLength(bytes.length);
		header.setMsgType(MsgTypeStr);
		message.setHeader(header);
		
		ctx.writeAndFlush(message);
		
		//将所有进入的加入到已存在的列表
		Iterator<Entry<Integer, FSPlayerInfo>> EnterToExtents = ClientObject.PlayerEnters.entrySet().iterator();
		while (EnterToExtents.hasNext()) {
		    Entry<Integer, FSPlayerInfo> entry = EnterToExtents.next();
		    ClientObject.PlayerExtents.put(entry.getKey(), entry.getValue());
		}
		
		//清空进入和离开列表
		ClientObject.PlayerEnters.clear();
		ClientObject.PlayerLeaves.clear();
		
	}
	
	/**
	 * @author sunweidong
	 * @category 登录后将非自身其他玩家数据同步到客户端
	 * */
	public static void addPlayerToClientObject(ClientGameObject ClientObject, Integer PlayerID) {
		Iterator<Entry<Integer, FSPlayerInfo>> entries = PlayerExtents.entrySet().iterator();
		while (entries.hasNext()) {
			 
		    Entry<Integer, FSPlayerInfo> entry = entries.next();
		    //将非自身玩家数据加入到进入列表
		    @SuppressWarnings("unused")
			Integer key = entry.getKey();
		    if(entry.getKey() != PlayerID) {
		    	ClientObject.PlayerEnters.put(entry.getKey(), entry.getValue());
		    }
		}
	}
	
	/**
	 * @author sunweidong
	 * @category 此方法为客户端同步服务器其他玩家和世界所有物品信息的同步类
	 * */
	public static void updatePlayerToClientObject(ChannelId channelId, ChannelHandlerContext ctx) {
		boolean isContain = false;
		//获取玩家的ID/Session
		Integer PlayerID = findClientID(channelId);
		//拿到玩家服务器游戏客户端对象
		ClientGameObject clientGameObject = clientGameObjects.get(PlayerID);
		
		//对比服务器已存在对象和客户端已存在对象 不包含部分添加到进入列表 其余加入到更新列表 离开列表全部加入
		Iterator<Entry<Integer, FSPlayerInfo>> entries = PlayerExtents.entrySet().iterator();
		while (entries.hasNext()) {
			//重置标记
			isContain = false;
		    Entry<Integer, FSPlayerInfo> entry = entries.next();
		    if(entry.getKey() != PlayerID) {
		    	isContain = clientGameObject.PlayerExtents.containsKey(entry.getKey());
			    if(isContain) {
			    	clientGameObject.PlayerExtents.put(entry.getKey(), entry.getValue());
			    }else {
			    	clientGameObject.PlayerEnters.put(entry.getKey(), entry.getValue());
			    }
		    }
		}
		//处理离开队列
		for(int i = 0; i < PlayerLeaves.size(); ++i) {
			clientGameObject.PlayerLeaves.add(PlayerLeaves.get(i));
			isContain = clientGameObject.PlayerExtents.containsKey(PlayerLeaves.get(i));
			//如果存在
			if(isContain) {
				//移除服务器存储的客户端游戏对象
		    	clientGameObject.PlayerExtents.remove(PlayerLeaves.get(i));
		    }else {
		    	//不存在该对象 不需要处理
		    }
		}
		
		//发送消息给客户端同步
		sendGameObjectToClient(ctx,clientGameObject);
	}
	
	/**
	 * @author sunweidong
	 * @category 发送消息给非自身客户端以外的玩家
	 * */
	public static void sendMsgToOtherClient(FSMessage message, ChannelHandlerContext ctx) {
		Iterator<Channel> Channels = FSChannelGroups.CHANNEL_GROUP.iterator();
		
		while (Channels.hasNext()) {
			 
		    Channel entry = Channels.next();
		    //给不是本机客户端发消息
		    if(entry.id() != ctx.channel().id()) {
		    	entry.writeAndFlush(message);
		    }
		}
//		ctx.writeAndFlush(message);
	}
	
	/**
	 * @author sunweidong
	 * @param ctx 
	 * @category 用户下线后移除服务器的数据  并发送消息通知其他客户端
	 * */
	public static void removePlayerInfoFromClient(ChannelHandlerContext ctx) {
		if(ctx.channel().isOpen()) {
			Integer playerID = findClientID(ctx.channel().id());
			//移除客户端channel索引
			Clients.remove(playerID);
			//移除客户端存储在服务器游戏对象数据
			clientGameObjects.remove(playerID);
			//缓存服务器中存储的客户端玩家数据
			FSPlayerInfo player = getPlayerByID(playerID);
			//移除客户端存储在服务器的所有玩家列表对象
			PlayerExtents.remove(playerID);
			//玩家ID加入到服务器离开列表
			PlayerLeaves.add(playerID);
			//发送一条ObjectSync消息
			broadCastSelfLeaveToAllClient(playerID,ctx.channel().id());
			//存储玩家的数据到数据库
			MySQLDBHelper.savePlayer(player);
		}
	}
	
	/**
	 * @author sunweidong
	 * @param playerID
	 * @category 通过玩家的ID/Session找到玩家信息
	 * */
	public static FSPlayerInfo getPlayerByID(Integer playerID) {
		return PlayerExtents.get(playerID);
	}
}
