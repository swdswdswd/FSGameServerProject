package com.fsgame.server;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.fsgame.db.FSPlayerInfo;
import com.fsgame.db.MessageType;
import com.fsgame.db.playerInfo.Transform;
import com.fsgame.facade.FSGameDataParsing;

@SuppressWarnings("deprecation")
public class FSGameServer {
	
	private static int playerID = 1;
	private static FSGameDataParsing dataParsing = new FSGameDataParsing();
	private static MessageType messageType = new MessageType();
	private static ArrayList<FSPlayerInfo> playerList = new ArrayList<FSPlayerInfo>();
	private static ArrayList<Thread> playerThreads = new ArrayList<Thread>();
//	private static Map<Integer, FSPlayerInfo> playerListMap = new HashMap<Integer, FSPlayerInfo>();
	private static Float locationX = 0.0f;
	
	
//	delegate void SetShowLogCallback();   //定义委托 
//	private void Form1_Load(object sender, EventArgs e)  
//    {  
//        showSynchLog();  
//     
//    }  
//	private void showSynchLog() {
//		// TODO Auto-generated method stub
//		 if (data_log.InvokeRequired)  
//         {   //控件是否跨线程？如果是，则执行括号里代码  
//             SetShowLogCallback setShowLogCallBack = new SetShowLogCallback(showSynchLog);  
//
//             data_log.Invoke(setShowLogCallBack);  
//         } 
//	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
			
		int port = 9999;
		@SuppressWarnings("resource")
		final ServerSocket serverSocket=new ServerSocket(port);
		
		System.out.println("服务器初始化完成，等待客户端连接....");
		
		System.out.println("主线程!");
		
		
		while(true){
			
			//等待客户端连接
			Socket socket = serverSocket.accept();
			//创建一个玩家客户端线程
			Thread playerThread = new Thread(new ServerTask(socket));
			//玩家线程添加到主线程池
			playerThreads.add(playerThread);
			//启动玩家线程
			playerThread.start();
		}
		
	}
	
	
	//等待客户端连接
	static class createNewTaskServer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	//服务器Task线程
	static class ServerTask implements Runnable {

		private Socket socket;
		private FSPlayerInfo playerInfo = new FSPlayerInfo();
		private int playerIndex;
		
		PrintStream outPrintWriter=null;
		BufferedInputStream in=null;
		
		public ServerTask(Socket socket) throws IOException{
			this.socket = socket;
			
			outPrintWriter=new PrintStream(socket.getOutputStream());
			
			//客户端消息处理
			in=new BufferedInputStream(socket.getInputStream());
			//初始化玩家信息
//			playerInfo.setPlayerIP(this.socket.getInetAddress().toString());
//			playerInfo.setExp(0);
//			playerInfo.setGrade(0);
//			playerInfo.setHeath(100);
//			playerInfo.setMap("TestMap");
//			playerInfo.setPlayerID(playerID);
//			playerID = playerID + 1;
//			playerInfo.setPlayerSkeletalMesh("SK_Mannequin");
//			playerInfo.setWeeponMesh("null");
//			
//			//初始化玩家的位置数据
//			Transform transform = new Transform(locationX,0.0f,100.0f,0.0f,0.0f,-144.0f,1.0f,1.0f,1.0f); 
//			playerInfo.setTransform(transform);
//			
			//向客户端发送玩家初始化数据
//			outPrintWriter.println(dataParsing.packgeDateToClient(messageType.initGame,dataParsing.playerInfoToStringInfo(playerInfo)));
			
			//将玩家加入集合
			playerList.add(playerInfo);
		
			//存储该玩家的数组下标
			playerIndex = playerList.size() - 1;
//			playerListMap.put(1,playerInfo);
			
			
			//重置locationX坐标
			locationX = locationX + 40.0f;
			
		}

		@Override
		public void run() {
			
			try {
				handleSocket();
			} catch (IOException e) {
				System.out.println("接收消息异常");
				try {
					in.close();
					outPrintWriter.close();
					socket.close();
					System.out.println("接收消息异常 连接关闭");
				} catch (IOException e1) {
					System.out.println("接收消息异常 连接关闭");
				}
			}
			
		}
		
		private void handleSocket() throws IOException{
			
			System.out.println("连接中!");
			
			byte data[] = null;
			int len = 0;
			byte[] datalen;
			
			socket.setSoTimeout(4000);
			
			while(socket.isConnected())
		     {
				datalen = new byte[8];
				//假设约定数据传输8位头长
				in.read(datalen);
				int length = Integer.parseInt(new String(datalen));//将字节数组转为字符串，再转为int类型
				data=new byte[length];
				try{
					len=in.read(data);
				}catch (SocketTimeoutException e) {
					// 超时4000ms后自动关闭Socket连接
					System.out.println("连接断开!");
				    if(in != null){
						//关闭输入流
						in.close();
					}
					if(outPrintWriter != null){
						//关闭输出流
						outPrintWriter.close();
					}
					socket.close();
					break;
				}
			    
		        //数据解析成utf8格式字符串
		        String s=new String(data, 0,len ,StandardCharsets.UTF_8);
		        //查看接收的数据
		        System.out.println("***********************************************************" + s+"消息长度:"+len );
//		        System.out.println(s+"len="+len+"bytelen=");
		        String[] location = dataParsing.unPackgeDateFromClient(s);
				//更新玩家位置信息
		        if(location!=null){
//		        	Transform transformOld = playerInfo.getTransform();
//			        Transform transform = new Transform(
//			        		transformOld.getLocationX()+Float.parseFloat(location[0]),
//			        		transformOld.getLocationX()+Float.parseFloat(location[1]), 
//			        		transformOld.getLocationX()+Float.parseFloat(location[2]), 
//			        		transformOld.getRotationX(), transformOld.getRotationY(), transformOld.getRotationZ(), 
//			        		transformOld.getScaleX(), transformOld.getScaleY(), transformOld.getScaleZ());
//			        playerInfo.setTransform(transform);
		        }
		        playerList.set(playerIndex, playerInfo);
//		        System.out.println("数据接收成功!");
		        //服务器向客户端发送消息
		        outPrintWriter.println("玩家数："+playerList.size());
		        //服务器向客户端同步其他玩家数据
		        outPrintWriter.println(dataParsing.packgeDateToClient(messageType.synchroPlayer, dataParsing.allPlayerInfoToStringInfo(playerList)));
		        
		     }
			if(socket==null || socket.isClosed()){
		    	 
				System.out.println("连接断开!");
		    	 if(in != null){
					//关闭输入流
					in.close();
				}
				if(outPrintWriter != null){
					//关闭输出流
					outPrintWriter.close();
				}
		     }
			System.out.println("数据接收完成!");
		}
		
	}
}
	
	

