package com.yc.bean2.tcpsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("�ͻ���׼������....");
		Socket client=new Socket("192.168.20.59",Server1.PORT);
		System.out.println("�ͻ���"+client.getInetAddress()+"�������˷�����������");
		
		DataInputStream dis=new DataInputStream(client.getInputStream());
		
		String word=dis.readUTF();
		System.out.println(client.getInetAddress()+"�Կͻ���˵��"+word);
		
		dis.close();
	}
}
