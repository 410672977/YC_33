package com.yc.bean4.httpclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

//����tcp��socket������webվ�㣬   ��Ϊwebվ���ǻ���Ӧ�ò�httpЭ�飬������Ҫʹ��socket����һ�� ����httpЭ��Ҫ�����������
//"GET / HTTP/1.1\r\n\r\n\r\n"
public class ClientSocket {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s=new Socket("218.196.14.220",8080);  //web������   ����http
		InputStream dis=s.getInputStream();
		OutputStream dos=s.getOutputStream();
		//������������Э���ƴ��
		String http="GET / HTTP/1.1\r\n\r\n\r\n";
		dos.write(http.getBytes());;
		dos.flush();
		
		byte[] bs=new byte[1024];
		int length=0;
		while( (length=dis.read(bs, 0, bs.length))!=-1){
			String response=new String(bs,0,length);
			System.out.println(response);
		}
		dos.close();
		dis.close();
		s.close();
	}
}
