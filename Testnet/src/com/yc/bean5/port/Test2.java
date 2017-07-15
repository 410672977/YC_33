package com.yc.bean5.port;

import java.net.Socket;

import javax.swing.JOptionPane;

public class Test2 {
	public static void main(String[] args) {
		PortScanTask pst=new PortScanTask("192.168.20.3",8880,8890, new NotifyResult(){
			@Override
			public void notifyScanResult(String info) {
				//System.out.println(info);
				JOptionPane.showMessageDialog(null, info);
			}
		});
		Thread t=new Thread(pst);
		t.start();
	}
}

class PortScanTask implements Runnable{
	private String ip;
	private int startPort;
	private int endPort;
	private NotifyResult notifyResult;

	public PortScanTask(String ip, int startPort, int endPort, NotifyResult notifyResult) {
		super();
		this.ip = ip;
		this.startPort = startPort;
		this.endPort = endPort;
		this.notifyResult = notifyResult;
	}

	@Override
	public void run() {
		for(int i=startPort;i<endPort;i++){
			try {
				Socket s=new Socket(ip,i);
				//System.out.println(i+"连接成功");
				if(notifyResult!=null){
					this.notifyResult.notifyScanResult(i+"连接成功");
				}
			} catch (Exception e) {
				//System.out.println("端口"+i+"不通");
				if(notifyResult!=null){
					this.notifyResult.notifyScanResult("端口"+i+"不通");
				}
			}
		}
		this.notifyResult.notifyScanResult("扫描完成...");
	}
}
//回调接口
interface NotifyResult{
	public void notifyScanResult(String info);
}