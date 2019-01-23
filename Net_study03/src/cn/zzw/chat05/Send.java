package cn.zzw.chat05;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/**
 * 使用多线程封装	发送端
 * 1 发送消息
 * 2 从控制台获取消息
 * 3 释放资源
 * 4 重写run
 * @author zzw
 *
 */
public class Send implements Runnable{
	private BufferedReader console;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	private String name;
	public Send(Socket client,String name) {
		this.isRunning=true;
		this.name=name;
		this.client=client;
		console=new BufferedReader(new InputStreamReader(System.in));
		try {
			dos=new DataOutputStream(client.getOutputStream());
			//发送名称
			send(name);
		} catch (IOException e) {
			System.out.println("客户端出错");
		}
	}


	@Override
	public void run() {
		while(isRunning) {
			String msg=getStrFromConsole();
			if (msg!=null) {
				send(msg);
			}
		}//while
		
	}
	
	//发送消息
	private void send(String str) {
		try {
			dos.writeUTF(str);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("-----------------3-----------------------");
			release();
		}
	}
	
	//从控制台获取字符串
	private String getStrFromConsole() {
		String string=null;
		try {
			string=console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return string;
		
	}
	
	private void release() {
		this.isRunning=false;
		ChatUtils.close(dos,client);
	}

}
