package com.fsgame.facade;

import java.util.ArrayList;

import com.fsgame.db.FSPlayerInfo;

/**
 * @author sunweidong
 * @category 消息打包使用
 * */
public class FSGameDataParsing {
	
	
	//将玩家信息打包成字符串传输
//	public String playerInfoToStringInfo(FSPlayerInfo fsPlayerInfo){
//		String playerStringInfo;
//		playerStringInfo = "fsPlayerInfo:" + "/" + 
//				fsPlayerInfo.getPlayerIP() + "/" + 
//				fsPlayerInfo.getPlayerID() + "/" + 
//				fsPlayerInfo.getHeath() + "/" + 
//				fsPlayerInfo.getExp() + "/" + 
//				fsPlayerInfo.getMap() + "/" + 
//				fsPlayerInfo.getGrade() + "/" + 
//				fsPlayerInfo.getWeeponMesh() + "/" + 
//				fsPlayerInfo.getPlayerSkeletalMesh() + "/" + 
//				fsPlayerInfo.getTransform().getLocationX() + "/" + 
//				fsPlayerInfo.getTransform().getLocationY() + "/" + 
//				fsPlayerInfo.getTransform().getLocationZ() + "/" + 
//				fsPlayerInfo.getTransform().getRotationX() + "/" + 
//				fsPlayerInfo.getTransform().getRotationY() + "/" + 
//				fsPlayerInfo.getTransform().getRotationZ() + "/" + 
//				fsPlayerInfo.getTransform().getScaleX() + "/" + 
//				fsPlayerInfo.getTransform().getScaleY() + "/" + 
//				fsPlayerInfo.getTransform().getScaleZ() + "/";
//		return playerStringInfo;
//	}
	
	//将收到的字符串信息解析成玩家数据
	public FSPlayerInfo stringInfoToPlayerInfo(String playerInfoString){
		
		return null;
	}
	
	//打包数据发送客户端
	public String packgeDateToClient(String messageType , String message){
		
		String messageTemp = "@@/" + messageType + "@@/" + message;
		
		return messageTemp;
	}
	
	//解析客户端数据   这里只判定了位移  后期增加
	public String[] unPackgeDateFromClient(String message){
		String[] location = null;
		String[] messages = message.split("@@/");
		switch (messages[0]) {
			case "UPDATELOCATIONX":{
				location = messages[1].split("/");
				System.out.println("-----------UPDATELOCATIONX--------------" + location[0] + location[1] + location[2] );
				return location;
			}
			case "UPDATELOCATIONY":{
				location = messages[1].split("/");
				System.out.println("------------UPDATELOCATIONY-------------" + location[0] + location[1] + location[2] );
				return location;
			}
		}
		return location;
	}
	
	//将玩家信息打包成字符串传输
		public String allPlayerInfoToStringInfo(ArrayList<FSPlayerInfo> playerList){
			String allPlayerStringInfo = "";
			
			for(int i=0;i<playerList.size();++i){
//				allPlayerStringInfo = allPlayerStringInfo + "@@@" + playerInfoToStringInfo(playerList.get(i));
			}
			return allPlayerStringInfo;
		}

}
