package com.yc.bean4.httpclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

//基于urlConnection的socket来访问web站点，  url封装协议
//提供了输出流 ，即可以通过post传参数
public class ClientUrlConnection {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		URL url=new URL("http://218.196.14.220:8080/doban/");   //1.访问主页
		URLConnection con=url.openConnection();   //urlConnection
		
		InputStream dis=con.getInputStream();
		
		System.out.println("urlconnectioin相对于url高级一点，可以取出各种协议信息："+con.getContentLengthLong());
		OutputStream dos=con.getOutputStream();   //也可以取出输出流，译发送参数到服务器
		
		byte[] bs=new byte[1024];
		int length=0;
		while( (length=dis.read(bs, 0, bs.length))!=-1){
			String response=new String(bs,0,length);
			System.out.println(response);
		}
//		dos.close();
		dis.close();
//		s.close();
	}
}
