package com.yc.bean3.udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

@SuppressWarnings("unused")
public class Sender1 {
	public static void main(String[] args) throws IOException {
		String s="hello world";
		//ע�⣺DatagramPacket�Ĺ��췽������    �����Σ� ���һ��������ʾ��һ̨�����ĵ�ַ�Ͷ˿�
		//UDP�е�ÿһ����������ָ��Ҫ���͵ĵ�ַ
		//                                   Ҫ�������ݵ��ֽ�����        Ҫ�������ݵĳ���                       ���շ��ĵ�ַ�Ͷ˿�
		DatagramPacket dp=new DatagramPacket(s.getBytes(), s.getBytes().length, new InetSocketAddress("127.0.0.1",3333));
		//ʹ�ñ����ϵ���һ���˿ڷ���
		DatagramSocket ds=new DatagramSocket(5678);  //5678ָ��������ʱʹ�õĶ˿�
		ds.send(dp);  //��
		ds.close();
	}
}
