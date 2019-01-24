package cn.zzw.server;

import java.io.IOException;
/**
 * 分发器
 */
import java.net.Socket;
/**
 * 分发器
 * @author zzw
 *
 */
public class Dispatcher1 implements Runnable{
	
	private Socket client;
	private Request request;
	private Response response;
	
	//构造函数
	public Dispatcher1(Socket client) {
		this.client=client;
		try {
			//获取请求协议
			request = new Request(client);
			//获取响应协议
			response=new Response(client);
		} catch (IOException e) {
			e.printStackTrace();
			this.release();
		}
	}

	@Override
	public void run() {
		try {
			Servlet servlet=WebApp.getServletFromUrl(request.getUrl());
			if (null!=servlet) {
				servlet.service(request, response);
				//关注了状态码
				System.out.println("-----------状态码:200-------------");
				response.pushToBrowser(200);
			}else{
				//错误页面
				System.out.println("-----------状态码:404-------------");
				response.pushToBrowser(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				System.out.println("-----------状态码:500------------");
				response.pushToBrowser(500);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		release();
	}
	
	
	//释放资源
	private void release() {
		try {
			client.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
