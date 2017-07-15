package com.yc.bean2.tcpsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server3 {
	public static final int PORT=9999;
	
	public static void main(String[] args) throws IOException{
		boolean flag=true;
		Scanner sc=new Scanner(System.in);
		System.out.println("服务器准备启动。。。");
		ServerSocket ss=new ServerSocket(PORT);
		System.out.println("服务器创建成功，监听"+PORT+"端口");
		while(flag){
			//服务器一直在监听9999端口，一旦有一个客户端连接上来，则accept()返回一个客户端的socket对象
			Socket client=ss.accept();   //没有客户端，则这个方法一直阻塞，不向下运行...
			System.out.println("有客户端连接上来了,它的地址是："+client.getInetAddress());
			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			String word="";
			do{
				String response=dis.readUTF();
				System.out.println("客户端"+client.getInetAddress()+"对服务器端说："+response);
				if(word.equals("bye")){
					System.out.println("客户端"+client.getInetAddress()+"主动断开与服务器的链接...");
					System.out.println("客户端"+client.getInetAddress()+"下线了...");
					break;
				}
				System.out.println("请输入您想对客户端说的话：");
				word=sc.nextLine();
				dos.writeUTF(word);
				dos.flush();
				if(word.equals("bye")){
					System.out.println("服务器主动断开与客户端的链接...");
					break;
				}
			}while(true);
			dos.flush();
			dos.close();
		}
	}	
}
