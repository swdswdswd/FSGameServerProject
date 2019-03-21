package com.fsgame.test;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket serverSocket=new ServerSocket(9999);
		Socket clientSocket=null;
		PrintStream outPrintWriter=null;
		BufferedInputStream in=null;
		Scanner inScanner=new Scanner(System.in);
		while(true)
		{
			System.out.println("等待客户端连接.....");
			clientSocket=serverSocket.accept();
			
//			System.out.println(clientSocket.getChannel());
//			
//			System.out.println(clientSocket.getReuseAddress());
//			
			
			outPrintWriter=new PrintStream(clientSocket.getOutputStream());
			
			outPrintWriter.println("s完美n巨化股份");
			
//			 System.out.println(clientSocket.getLocalAddress());
			 
			
//			 for(int j = 0;j<5;++j){
//				 for(int i = 0;i<5;++i){
//					 
//					 outPrintWriter.print("22222");
//					 
//					 System.out.print("��������22222���");
//				 }
//				 Thread.sleep(500);
//			 }
			
			 
			 
			 
			while(true)
			{
				if(clientSocket.isConnected())
			     {
					in=new BufferedInputStream(clientSocket.getInputStream());
			        byte b[]=new byte[1024];
			        int len=in.read(b);
			        
//			        String s=new String(new String(b,0,len).getBytes(),"utf-8");
			        System.out.println(new String(b, 0,len ,StandardCharsets.UTF_8)+"len="+len+"bytelen=");
//			        System.out.println(new String(b,0,len));
//					System.out.print("������Ҫ���͵�����:");
//					System.out.print("�����������");
//					String string=inScanner.next();
//					outPrintWriter.println("22222");
					
					
//					 for(int j = 0;j<50;++j){
//					 for(int i = 0;i<50;++i){
//						 
//						 outPrintWriter.print("22222");
//						 
//						 System.out.print("��������22222���");
//					 }
//					 Thread.sleep(500);
//				 }
					
			     }	
//			     }else{
//			    	 //�ͻ��˶Ͽ�����  
//			    	 outPrintWriter.print("�ͻ��˶Ͽ�����");
//			    	 clientSocket.close();
//			    	 clientSocket = null;
//			    	 outPrintWriter = null;
//			    	 break;
			     }
			}
//		}
	}

}
