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
		//注意：DatagramPacket的构造方法参数    三个参： 最后一个参数表示另一台机器的地址和端口
		//UDP中的每一个包都必须指明要发送的地址
		//                                   要发的内容的字节数组        要发的内容的长度                       接收方的地址和端口
		DatagramPacket dp=new DatagramPacket(s.getBytes(), s.getBytes().length, new InetSocketAddress("127.0.0.1",3333));
		//使用本机上的哪一个端口发送
		DatagramSocket ds=new DatagramSocket(5678);  //5678指本机发送时使用的端口
		ds.send(dp);  //发
		ds.close();
	}
}
