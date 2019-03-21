/**
 * 
 */
package com.fsgame.mode;

/**
 * @author sunweidong
 *
 */
import java.io.Serializable;


public class FSMessage implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MessageHeader header;                        //消息头部长度
	private byte[] data;                                 //消息体字节
	

    public MessageHeader getHeader() {
        return header;
    }

    public void setHeader(MessageHeader header) {
        this.header = header;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "header=" + header +
                ", data=" + data +
                '}';
    }
    public byte[] MessageToByte() {
    	return null;
	}
}