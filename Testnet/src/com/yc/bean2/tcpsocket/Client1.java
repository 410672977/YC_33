package com.yc.bean2.tcpsocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("客户端准备启动....");
		Socket client=new Socket("192.168.20.59",Server1.PORT);
		System.out.println("客户端"+client.getInetAddress()+"连接上了服务器。。。");
		//向服务器发送一条数据   hello  world,i’m jj
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		
		dos.writeUTF("hello  world,i’m zrz");
		dos.flush();
		dos.close();
	}
}
