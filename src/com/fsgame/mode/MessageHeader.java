package com.fsgame.mode;

import java.io.Serializable;

/***
 * 消息包头定义
 * */
public class MessageHeader implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private int length;
    private String msgType;
    private String msgTypeClassName;

  

	public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Header{" +
                ", length=" + length +
                msgType+
                '}';
    }

	/**
	 * @return msgType
	 */
	public String getMsgType() {
		return msgType;
	}

	/**
	 * @param msgType 要设置的 msgType
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getMsgTypeClassName() {
		return msgTypeClassName;
	}

	public void setMsgTypeClassName(String msgTypeClassName) {
		this.msgTypeClassName = msgTypeClassName;
	}
}