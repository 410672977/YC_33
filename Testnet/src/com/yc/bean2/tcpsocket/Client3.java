package com.yc.bean2.tcpsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client3 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		boolean flag=true;
		Scanner sc=new Scanner(System.in);
		System.out.println("�ͻ���׼������....");
		Socket client=new Socket("localhost",Server1.PORT);
		System.out.println("�ͻ���"+client.getInetAddress()+"�������˷�����������");
		String word="";
		DataInputStream dis=new DataInputStream(client.getInputStream());
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		do{
			System.out.println("����Է���������");
			word=sc.nextLine();   //����
			dos.writeUTF(word);          //д��������
			dos.flush();
			if(word.equals("bye")){
				System.out.println("�ͻ��������Ͽ��������������...");
				break;
			}
			String response=dis.readUTF();  //����
			System.out.println("�������Կͻ���˵��"+response);
			if(word.equals("bye")){
				System.out.println("�����������Ͽ���ͻ��˵�����...");
				break;
			}			
		}while(flag);
		dos.flush();
		dos.close();
	}
}
