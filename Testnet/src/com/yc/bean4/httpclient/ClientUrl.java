package com.yc.bean4.httpclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

//基于url的socket来访问web站点，  url封装协议
//url得到的结果没有   HTTP响应头
public class ClientUrl {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
//		Socket s=new Socket("218.196.14.220",8080);  //web服务器   基于http
//		InputStream dis=s.getInputStream();
//		OutputStream dos=s.getOutputStream();
//		//由浏览器来完成协议的拼接
//		String http="GET / HTTP/1.1\r\n\r\n\r\n";
//		dos.write(http.getBytes());;
//		dos.flush();
		
		URL url=new URL("http://218.196.14.220:8080/doban/");   //1.访问主页
		InputStream dis=url.openStream();   //只有输入没有输出流 ，意味着不能通过   URL类向服务器传送参数
		
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
