package com.yc.bean2.tcpsocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("�ͻ���׼������....");
		Socket client=new Socket("192.168.20.59",Server1.PORT);
		System.out.println("�ͻ���"+client.getInetAddress()+"�������˷�����������");
		//�����������һ������   hello  world,i��m jj
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		
		dos.writeUTF("hello  world,i��m zrz");
		dos.flush();
		dos.close();
	}
}
