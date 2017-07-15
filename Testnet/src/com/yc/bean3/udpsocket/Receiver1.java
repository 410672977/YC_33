package com.yc.bean3.udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

@SuppressWarnings("unused")
public class Receiver1 {
	public static void main(String[] args) throws IOException {
		
		boolean flag=true;
		byte buf[]=new byte[1024];//字节数组，用于缓冲数据
		//空包：DatagramPacket
		DatagramPacket dp=new DatagramPacket(buf, buf.length);   //创建一个数据包对象
		DatagramSocket ds=new DatagramSocket(3333);   //构建一个数据包socket,占用UDP的3333端口，进行接收
		while(flag){
			ds.receive(dp);//用这个3333端口来接收数据，存在dp数据包对象中的buf缓冲空间中
			System.out.println(new String(buf,0,dp.getLength()));   //将字节数组转换成字符串输出
		}
		ds.close();
	}
}
