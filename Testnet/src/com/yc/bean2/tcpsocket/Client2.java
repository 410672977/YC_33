package com.yc.bean2.tcpsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("客户端准备启动....");
		Socket client=new Socket("192.168.20.59",Server1.PORT);
		System.out.println("客户端"+client.getInetAddress()+"连接上了服务器。。。");
		
		DataInputStream dis=new DataInputStream(client.getInputStream());
		
		String word=dis.readUTF();
		System.out.println(client.getInetAddress()+"对客户端说："+word);
		
		dis.close();
	}
}
