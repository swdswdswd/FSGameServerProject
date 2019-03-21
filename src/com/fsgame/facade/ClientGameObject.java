/**
 * 
 */
package com.fsgame.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fsgame.db.FSPlayerInfo;

/**
 * @author sunweidong
 *
 */
public class ClientGameObject {
	//客户端已经存在的玩家信息
	public Map<Integer, FSPlayerInfo> PlayerExtents = new HashMap<Integer, FSPlayerInfo>();
	
	//客户端刚刚进入的玩家信息
	public Map<Integer, FSPlayerInfo> PlayerEnters = new HashMap<Integer, FSPlayerInfo>();
	
	//客户端离开的玩家信息
	public ArrayList<Integer> PlayerLeaves = new ArrayList<>();
}