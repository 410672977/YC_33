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
		System.out.println("客户端准备启动....");
		Socket client=new Socket("localhost",Server1.PORT);
		System.out.println("客户端"+client.getInetAddress()+"连接上了服务器。。。");
		String word="";
		DataInputStream dis=new DataInputStream(client.getInputStream());
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		do{
			System.out.println("您想对服务器讲：");
			word=sc.nextLine();   //阻塞
			dos.writeUTF(word);          //写到服务器
			dos.flush();
			if(word.equals("bye")){
				System.out.println("客户端主动断开与服务器的链接...");
				break;
			}
			String response=dis.readUTF();  //阻塞
			System.out.println("服务器对客户端说："+response);
			if(word.equals("bye")){
				System.out.println("服务器主动断开与客户端的链接...");
				break;
			}			
		}while(flag);
		dos.flush();
		dos.close();
	}
}
