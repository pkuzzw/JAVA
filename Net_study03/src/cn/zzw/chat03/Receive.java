package cn.zzw.chat03;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 使用多线程封装	接收端
 * 1 接收消息
 * 2 释放资源
 * 3 重写run
 * @author zzw
 *
 */

public class Receive implements Runnable {
	private DataInputStream dis;
	private Socket client;
	private boolean isRunning=true;
	public Receive(Socket client) {
		this.client=client;
		isRunning=true;
		try {
			dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			isRunning=false;
			System.out.println("------------------2--------------------");
		}
	}

	//接收消息
	private String receive() {
		String str = null;
		try {
			str = dis.readUTF();
//			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("----------------4---------------------");
			release();
		}
		return str;
	}
	


	@Override
	public void run() {
		while (isRunning) {
			String msg=receive();
			if (msg!=null) {
				System.out.println(msg);
			}
		}
		
	}
	
	private void release() {
		this.isRunning=false;
		ChatUtils.close(dis,client);
		
	}

}
