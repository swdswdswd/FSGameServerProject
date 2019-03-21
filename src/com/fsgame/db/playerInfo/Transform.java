package com.fsgame.db.playerInfo;

public class Transform {
	// 玩家location
	private Float locationX;
	private Float locationY;
	private Float locationZ;
	// 玩家rotation
	private Float rotationX;
	private Float rotationY;
	private Float rotationZ;
	// 玩家Scale
	private Float scaleX;
	private Float scaleY;
	private Float scaleZ;
	
	//初始化构造函数
	public Transform(Float locationX,Float locationY,Float locationZ,Float rotationX,Float rotationY,Float rotationZ,Float scaleX,Float scaleY
			,Float scaleZ){
		this.locationX = locationX;
		this.locationY = locationY;
		this.locationZ = locationZ;
		this.rotationX = rotationX;
		this.rotationY = rotationY;
		this.rotationZ = rotationZ;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
		this.scaleZ = scaleZ;
	}

	//默认构造函数
	public Transform() {
		// TODO Auto-generated constructor stub
	}

	public Float getLocationX() {
		return locationX;
	}

	public void setLocationX(Float locationX) {
		this.locationX = locationX;
	}

	public Float getLocationY() {
		return locationY;
	}

	public void setLocationY(Float locationY) {
		this.locationY = locationY;
	}

	public Float getLocationZ() {
		return locationZ;
	}

	public void setLocationZ(Float locationZ) {
		this.locationZ = locationZ;
	}

	public Float getRotationX() {
		return rotationX;
	}

	public void setRotationX(Float rotationX) {
		this.rotationX = rotationX;
	}

	public Float getRotationY() {
		return rotationY;
	}

	public void setRotationY(Float rotationY) {
		this.rotationY = rotationY;
	}

	public Float getRotationZ() {
		return rotationZ;
	}

	public void setRotationZ(Float rotationZ) {
		this.rotationZ = rotationZ;
	}

	public Float getScaleX() {
		return scaleX;
	}

	public void setScaleX(Float scaleX) {
		this.scaleX = scaleX;
	}

	public Float getScaleY() {
		return scaleY;
	}

	public void setScaleY(Float scaleY) {
		this.scaleY = scaleY;
	}

	public Float getScaleZ() {
		return scaleZ;
	}

	public void setScaleZ(Float scaleZ) {
		this.scaleZ = scaleZ;
	}

}
