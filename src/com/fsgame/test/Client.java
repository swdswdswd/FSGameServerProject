package com.fsgame.test;
import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class Client {
	public static void main(String[] args) throws Exception {
      Socket client=null;
      client=new Socket("localhost",9998);
      PrintStream outPrintStream=new PrintStream(client.getOutputStream());
      //DataInputStream inputStream=new DataInputStream(client.getInputStream());
     BufferedInputStream inputStream=new BufferedInputStream(client.getInputStream());
     Scanner input=new Scanner(System.in);
      while(true)
     {
      System.out.print("客户端发送数据: ");
      String string=new String(input.next().getBytes() ,StandardCharsets.UTF_8);
      outPrintStream.print(string);
      //Thread.sleep(5000);
      byte b[]=new byte[1024];
      int len=inputStream.read(b);
      System.out.println("服务端回应："+new String(b,0,len));
      //Thread.sleep(5000);
     }
}
}
