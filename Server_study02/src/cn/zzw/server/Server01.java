package cn.zzw.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标:	使用ServerSocket建立与浏览器的连接,获取请求协议
 * @author zzw
 *
 */

public class Server01 {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		Server01 server=new Server01();
		server.start();
		
	}
	
	//启动服务
	public void start() {
		try {
			serverSocket=new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
		}
	}

	
	//停止服务
	public void receive() {
		try {
			//一个client就代表一个浏览器
			Socket client=serverSocket.accept();
			System.out.println("一个客户端建立了连接");
			//获取请求协议
			InputStream is=client.getInputStream();
			byte[] datas=new byte[1024*1024];
			int len=is.read(datas);
			System.out.println("读取了\t"+len+"\t数据");
			String requestInfo=new String(datas,0,len);
			System.out.println(requestInfo);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
		
	}
	
	
	
	//接收连接处理
	public void stop() {

		
		
	}
	

}
