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
 */

public class Server06 {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		Server06 server=new Server06();
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
			Servlet servlet=null;
			if (request.getUrl().equals("login")) {
				servlet=new LoginServlet();
			}else if (request.getUrl().equals("reg")) {
				servlet=new RegisterServlet();
			}else {
				//首页
			}
			//关注了内容,同时关注了我们的状态
			servlet.service(request, response);
			response.pushToBrowser(200);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
		
	}
	
	
	
	//接收连接处理
	public void stop() {

		
		
	}
	

}
