package com.fsgame.db;


public class FSPlayerInfo {
	private int playerBaseId;
	private String playerName;
	private float hp;
	private float x;
	private float y;
	private float z;
	private float o;
	private int mapId;
//	private String playerIP;            //玩家IP
//	private int playerID;               //玩家ID
//	private int heath;                  //玩家生命
//	private int exp;                    //玩家经验值
//	private String map;                 //玩家地图
//	private int grade;                  //玩家等级
//	private String playerSkeletalMesh;  //玩家的Mesh  
//	private String weeponMesh;          //玩家武器Mesh
//	private Transform transform;        //玩家Transform
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getZ() {
		return z;
	}
	public void setZ(float z) {
		this.z = z;
	}
	public float getO() {
		return o;
	}
	public void setO(float o) {
		this.o = o;
	}
	public int getMapId() {
		return mapId;
	}
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	public int getPlayerBaseId() {
		return playerBaseId;
	}
	public void setPlayerBaseId(int playerBaseId) {
		this.playerBaseId = playerBaseId;
	}
	public float getHp() {
		return hp;
	}
	public void setHp(float hp) {
		this.hp = hp;
	}
	
	
//	public String getPlayerIP() {
//		return playerIP;
//	}
//	public void setPlayerIP(String playerIP) {
//		this.playerIP = playerIP;
//	}
//	public int getPlayerID() {
//		return playerID;
//	}
//	public void setPlayerID(int playerID) {
//		this.playerID = playerID;
//	}
//	public int getHeath() {
//		return heath;
//	}
//	public void setHeath(int heath) {
//		this.heath = heath;
//	}
//	public int getExp() {
//		return exp;
//	}
//	public void setExp(int exp) {
//		this.exp = exp;
//	}
//	public String getMap() {
//		return map;
//	}
//	public void setMap(String map) {
//		this.map = map;
//	}
//	public int getGrade() {
//		return grade;
//	}
//	public void setGrade(int grade) {
//		this.grade = grade;
//	}
//	public String getWeeponMesh() {
//		return weeponMesh;
//	}
//	public void setWeeponMesh(String weeponMesh) {
//		this.weeponMesh = weeponMesh;
//	}
//	public String getPlayerSkeletalMesh() {
//		return playerSkeletalMesh;
//	}
//	public void setPlayerSkeletalMesh(String playerSkeletalMesh) {
//		this.playerSkeletalMesh = playerSkeletalMesh;
//	}
//	public Transform getTransform() {
//		return transform;
//	}
//	public void setTransform(Transform transform) {
//		this.transform = transform;
//	}

}
