package cn.zzw.server;

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
 * @author zzw
 * 
 * @author zzw
 *
 */

public class Server07 {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		Server07 server=new Server07();
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
			Request request=new Request(client);
			//获取响应协议
			Response response=new Response(client);
			Servlet servlet=WebApp.getServletFromUrl(request.getUrl());
			if (null!=servlet) {
				servlet.service(request, response);
				response.pushToBrowser(200);
			}else {
				//错误页面
				response.pushToBrowser(404);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
		
	}
	
	
	
	//接收连接处理
	public void stop() {

		
		
	}
	

}
