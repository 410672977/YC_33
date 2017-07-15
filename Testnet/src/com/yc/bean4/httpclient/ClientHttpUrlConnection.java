package com.yc.bean4.httpclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

//����urlConnection��socket������webվ�㣬  url��װЭ��
//�ṩ������� ��������ͨ��post������
public class ClientHttpUrlConnection {
	
	public static void main(String[] args) throws UnknownHostException, IOException {

		URL url=new URL("http://218.196.14.220:8080/doban/");   //1.������ҳ
		HttpURLConnection con=(HttpURLConnection)url.openConnection();   //��urlConnectionǿ��ת��ΪHttpURLConnection
		con.setRequestProperty("User-Agent", "the great king");
		con.setDoOutput(true);  //�������
		
		OutputStream dos=con.getOutputStream();   //Ҳ����ȡ����������뷢�Ͳ�����������
		//HttpUrlConnectionר�����HTTPЭ��
		
		InputStream dis=con.getInputStream();
		
		System.out.println("urlconnectioin�����url�߼�һ�㣬����ȡ������Э����Ϣ��"+con.getContentLengthLong());
		System.out.println(con.getRequestProperty("Host"));
		System.out.println(con.getRequestProperty("User-Agent"));
		System.out.println(con.getRequestProperty("Cookie"));
		
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
