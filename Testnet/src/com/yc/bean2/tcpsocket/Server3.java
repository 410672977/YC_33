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
		System.out.println("������׼������������");
		ServerSocket ss=new ServerSocket(PORT);
		System.out.println("�����������ɹ�������"+PORT+"�˿�");
		while(flag){
			//������һֱ�ڼ���9999�˿ڣ�һ����һ���ͻ���������������accept()����һ���ͻ��˵�socket����
			Socket client=ss.accept();   //û�пͻ��ˣ����������һֱ����������������...
			System.out.println("�пͻ�������������,���ĵ�ַ�ǣ�"+client.getInetAddress());
			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			String word="";
			do{
				String response=dis.readUTF();
				System.out.println("�ͻ���"+client.getInetAddress()+"�Է�������˵��"+response);
				if(word.equals("bye")){
					System.out.println("�ͻ���"+client.getInetAddress()+"�����Ͽ��������������...");
					System.out.println("�ͻ���"+client.getInetAddress()+"������...");
					break;
				}
				System.out.println("����������Կͻ���˵�Ļ���");
				word=sc.nextLine();
				dos.writeUTF(word);
				dos.flush();
				if(word.equals("bye")){
					System.out.println("�����������Ͽ���ͻ��˵�����...");
					break;
				}
			}while(true);
			dos.flush();
			dos.close();
		}
	}	
}
