package com.yc.bean3.udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

@SuppressWarnings("unused")
public class Receiver1 {
	public static void main(String[] args) throws IOException {
		
		boolean flag=true;
		byte buf[]=new byte[1024];//�ֽ����飬���ڻ�������
		//�հ���DatagramPacket
		DatagramPacket dp=new DatagramPacket(buf, buf.length);   //����һ�����ݰ�����
		DatagramSocket ds=new DatagramSocket(3333);   //����һ�����ݰ�socket,ռ��UDP��3333�˿ڣ����н���
		while(flag){
			ds.receive(dp);//�����3333�˿����������ݣ�����dp���ݰ������е�buf����ռ���
			System.out.println(new String(buf,0,dp.getLength()));   //���ֽ�����ת�����ַ������
		}
		ds.close();
	}
}
