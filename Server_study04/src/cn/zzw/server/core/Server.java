package cn.zzw.server.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Server06:
 * 目标:	加入了Servlet
 * 		解耦了代码业务
 * 
 * 
 * Server07:
 * 目标:	整合配置文件
 * 
 * Server08:
 * 目标:		多线程处理加入分发器
 * 
 * Server09:
 * 目标:处理 404 505和首页
 * 
 * @author zzw
 *
 */

public class Server {
	private ServerSocket serverSocket;
	private boolean isRunning;
	public static void main(String[] args) {
		Server server=new Server();
		server.start();
		
	}
	
	//启动服务
	public void start() {
		try {
			serverSocket=new ServerSocket(8888);
			isRunning=true;
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
			stop();
		}
	}

	
	//停止服务
	public void receive() {
		while(isRunning) {
			try {
				//一个client就代表一个浏览器
				Socket client=serverSocket.accept();
				System.out.println("一个客户端建立了连接");
				//多线程处理
				new Thread(new Dispatcher(client)).start();

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("客户端错误");
			}
		}
		
	}
	
	
	
	//接收连接处理
	public void stop() {
		isRunning=false;
		try {
			serverSocket.close();
			System.out.println("服务器已停止");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
