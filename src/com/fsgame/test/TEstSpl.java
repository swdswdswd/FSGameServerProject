package com.fsgame.test;

public class TEstSpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cc = "254@@/54/244";
		String[] dd = cc.split("@@/");
		for(int i = 0;i<dd.length;++i){
			System.out.println(dd[i]);
		}
	}

}
