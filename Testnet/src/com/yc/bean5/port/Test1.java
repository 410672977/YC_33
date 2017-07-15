package com.yc.bean5.port;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test1 {
	public static void main(String[] args) {
		for(int i=3306;i<3307;i++){
			try {
				Socket s=new Socket("192.168.20.122",i);
				System.out.println(i+"连接成功");
			} catch (Exception e) {
				System.out.println("端口"+i+"不通");
			}
		}
	}
}
