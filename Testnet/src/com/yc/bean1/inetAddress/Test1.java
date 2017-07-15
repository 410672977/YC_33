package com.yc.bean1.inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test1 {
	
	public static void main(String[] args) throws UnknownHostException{
		System.out.println("本地信息");
		//获取本地机器名及ip地址
		InetAddress local=InetAddress.getLocalHost();
		String localIP=String.valueOf(local);
		System.out.println(localIP);
		
		//只获取本机ip地址
		String hostAddress=local.getHostAddress();
		System.out.println(hostAddress);
		
		//只获取本机的机器名
		String localName=local.getHostName();
		System.out.println(localName);
		
		//远程对象信息
		System.out.println("远程信息：");
		
		//获取yahoo服务器的机器名及ip地址
		InetAddress ip=InetAddress.getByName("www.yahoo.com");
		String ip_str=String.valueOf(ip);
		System.out.println(ip_str);
		
		//只获取yahoo服务器机器名
		String ipName=ip.getHostName();
		System.out.println(ipName);
		
		//只获取yahoo服务器地址
		String ipAddress=ip.getHostAddress();
		System.out.println(ipAddress);
		
		//多个ip地址信息
		System.out.println("多个ip地址信息");
		InetAddress[] address=InetAddress.getAllByName("www.orcle.com");
		for(InetAddress a : address){
			System.out.println(a);
		}
	}
}
