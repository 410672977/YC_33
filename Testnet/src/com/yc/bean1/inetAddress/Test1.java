package com.yc.bean1.inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test1 {
	
	public static void main(String[] args) throws UnknownHostException{
		System.out.println("������Ϣ");
		//��ȡ���ػ�������ip��ַ
		InetAddress local=InetAddress.getLocalHost();
		String localIP=String.valueOf(local);
		System.out.println(localIP);
		
		//ֻ��ȡ����ip��ַ
		String hostAddress=local.getHostAddress();
		System.out.println(hostAddress);
		
		//ֻ��ȡ�����Ļ�����
		String localName=local.getHostName();
		System.out.println(localName);
		
		//Զ�̶�����Ϣ
		System.out.println("Զ����Ϣ��");
		
		//��ȡyahoo�������Ļ�������ip��ַ
		InetAddress ip=InetAddress.getByName("www.yahoo.com");
		String ip_str=String.valueOf(ip);
		System.out.println(ip_str);
		
		//ֻ��ȡyahoo������������
		String ipName=ip.getHostName();
		System.out.println(ipName);
		
		//ֻ��ȡyahoo��������ַ
		String ipAddress=ip.getHostAddress();
		System.out.println(ipAddress);
		
		//���ip��ַ��Ϣ
		System.out.println("���ip��ַ��Ϣ");
		InetAddress[] address=InetAddress.getAllByName("www.orcle.com");
		for(InetAddress a : address){
			System.out.println(a);
		}
	}
}
