package com.yc.bean2.tcpsocket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static final int PORT=9999;
	
	public static void main(String[] args) throws IOException{
		boolean flag=true;
		System.out.println("服务器准备启动。。。");
		ServerSocket ss=new ServerSocket(PORT);
		System.out.println("服务器创建成功，监听"+PORT+"端口");
		while(flag){
			//服务器一直在监听9999端口，一旦有一个客户端连接上来，则accept()返回一个客户端的socket对象
			Socket client=ss.accept();   //没有客户端，则这个方法一直阻塞，不向下运行...
			System.out.println("有客户端连接上来了,它的地址是："+client.getInetAddress());
			DataInputStream dis=new DataInputStream(client.getInputStream());
			
			String word=dis.readUTF();
			System.out.println(client.getInetAddress()+"对服务器说："+word);
			
			dis.close();
		}
	}
}
