package com.yc.bean2.tcpsocket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static final int PORT=9999;
	
	public static void main(String[] args) throws IOException{
		boolean flag=true;
		System.out.println("������׼������������");
		ServerSocket ss=new ServerSocket(PORT);
		System.out.println("�����������ɹ�������"+PORT+"�˿�");
		while(flag){
			//������һֱ�ڼ���9999�˿ڣ�һ����һ���ͻ���������������accept()����һ���ͻ��˵�socket����
			Socket client=ss.accept();   //û�пͻ��ˣ����������һֱ����������������...
			System.out.println("�пͻ�������������,���ĵ�ַ�ǣ�"+client.getInetAddress());
			DataInputStream dis=new DataInputStream(client.getInputStream());
			
			String word=dis.readUTF();
			System.out.println(client.getInetAddress()+"�Է�����˵��"+word);
			
			dis.close();
		}
	}
}
