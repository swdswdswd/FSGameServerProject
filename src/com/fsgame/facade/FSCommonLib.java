/**
 * 
 */
package com.fsgame.facade;

import java.util.HashMap;
import java.util.Map;

import com.fsgame.db.FSPlayerInfo;
import com.fsgame.proto.MSGBaseCommon.Coordinate;
import com.fsgame.proto.MSGPlayerCommon.PlayerCommon;


/**
 * @author sunweidong
 * @category 初始化工具包
 *1、此类提供所有的静态函数库  包括消息的初始化map集合 
 *2、在服务器启动时初始化一次 
 *3、后面考虑使用文件读取的方式来初始化集合
 */
public class FSCommonLib {

	public static Map<String, String> ProtocolMap = new HashMap<String, String>();
	
	static {
		ProtocolMap.put("0001", "com.fsgame.controllerImp.BaseCommon");
		ProtocolMap.put("0002", "com.fsgame.controllerImp.ObjectCommon");
		ProtocolMap.put("0003", "com.fsgame.controllerImp.PlayerCommon");
		ProtocolMap.put("0004", "com.fsgame.controllerImp.LoginGameC2SImp");
		ProtocolMap.put("0005", "class com.fsgame.proto.MSGLoginGameS2C$LoginGameS2C");
		ProtocolMap.put("0006", "com.fsgame.controllerImp.LoadGameMapC2SImp");
		ProtocolMap.put("0007", "class com.fsgame.proto.MSGLoadGameMapS2C$LoadGameMapS2C");
		ProtocolMap.put("0008", "class com.fsgame.proto.MSGObjectSyncS2C$ObjectSyncS2C");
		ProtocolMap.put("0009", "com.fsgame.controllerImp.HeatALiveC2SImp");
		ProtocolMap.put("0010", "class com.fsgame.proto.MSGHeatALiveS2C$HeatALiveS2C");
		ProtocolMap.put("0011", "com.fsgame.controllerImp.PlayerMoveC2SImp");
		ProtocolMap.put("0012", "class com.fsgame.proto.MSGPlayerMoveS2C$PlayerMoveS2C");
		ProtocolMap.put("0013", "com.fsgame.controllerImp.ChatC2SImp");
		ProtocolMap.put("0014", "class com.fsgame.proto.MSGChatS2C$ChatS2C");
		ProtocolMap.put("0015", "com.fsgame.controllerImp.SkillC2SImp");
		ProtocolMap.put("0016", "class com.fsgame.proto.MSGSkillS2C$SkillS2C");
	}
	
	public FSCommonLib() {
		initProtocolMap();

	}
	
	private void initProtocolMap() {
		
	}

	public static String Int2String(int MsgLength) {
		String str = "";
	        if(MsgLength < 10 && MsgLength >= 0) {
	        	str = "000" + MsgLength;
	        }else if( MsgLength >= 10 && MsgLength < 100){
	        	str = "00" + MsgLength;
	        }else if(MsgLength >= 100 & MsgLength < 1000) {
	        	str = "0" + MsgLength;
	        }else if(MsgLength >= 1000 && MsgLength <= 9999) {
	        	str = "" + MsgLength;
	        }
		return str;
	}

	public static String getKey(String str) {
		for(Map.Entry<String, String> entry : ProtocolMap.entrySet()){
			
			if(str.equals(entry.getValue()))
					
				return entry.getKey();
			}
		
		return null;
	}
	
	/**
	 * 将玩家protobuf对象转化成java db对象
	 * */
	public static FSPlayerInfo CreatePlayerInfo(PlayerCommon.Builder player) {
		FSPlayerInfo playerInfo = new FSPlayerInfo();
		playerInfo.setPlayerName(player.getName());
		playerInfo.setPlayerBaseId(player.getBaseid());
		playerInfo.setX(player.getCoor().getX());
		playerInfo.setY(player.getCoor().getY());
		playerInfo.setZ(player.getCoor().getZ());
		playerInfo.setO(player.getCoor().getO());
		playerInfo.setMapId(player.getCoor().getMap());
		return playerInfo;
	}
	
	/**
	 * 将java db 对象转化成protobuf对象
	 * */
	public static PlayerCommon createPlayerPBObject(FSPlayerInfo playerInfo) {
		PlayerCommon.Builder player = PlayerCommon.newBuilder();
		player.setName(playerInfo.getPlayerName());
		player.setBaseid(playerInfo.getPlayerBaseId());
		Coordinate.Builder coor = Coordinate.newBuilder();
		coor.setX(playerInfo.getX());
		coor.setY(playerInfo.getY());
		coor.setZ(playerInfo.getZ());
		coor.setO(playerInfo.getO());
		coor.setMap(playerInfo.getMapId());
		player.setCoor(coor.build());
		return player.build();
	}
}
