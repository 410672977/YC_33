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

//����urlConnection��socket������webվ�㣬  url��װЭ��
//�ṩ������� ��������ͨ��post������
public class ClientUrlConnection {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		URL url=new URL("http://218.196.14.220:8080/doban/");   //1.������ҳ
		URLConnection con=url.openConnection();   //urlConnection
		
		InputStream dis=con.getInputStream();
		
		System.out.println("urlconnectioin�����url�߼�һ�㣬����ȡ������Э����Ϣ��"+con.getContentLengthLong());
		OutputStream dos=con.getOutputStream();   //Ҳ����ȡ����������뷢�Ͳ�����������
		
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
