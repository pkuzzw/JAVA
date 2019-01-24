package cn.zzw.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 目标:封装响应信息
 * 1	内容可以动态添加
 * 2	关注状态吗,拼接好响应的协议信息
 * 
 * @author zzw
 *
 */

public class Server04 {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		Server04 server=new Server04();
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
			Request1 request=new Request1(client);
			Response response=new Response(client);
			//关注了内容,同时关注了我们的状态
			response.print("<html>");
			response.print("<head>");
			response.print("<title>");
			response.print("服务器响应成功");
			response.print("</title>");
			response.print("</head>");
			response.print("<body>");
			response.print(".......终于回来了......");
			response.print("</body>");
			response.print("</html>");
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
