package cn.zzw.server;
/**
 * 分发器:加入状态内容处理 404 505 首页
 */

import java.io.IOException;
import java.io.InputStream;
/**
 * 分发器
 */
import java.net.Socket;

public class Dispatcher implements Runnable{
	
	private Socket client;
	private Request request;
	private Response response;
	
	//构造函数
	public Dispatcher(Socket client) {
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
			if (null== request.getUrl() || request.getUrl().equals("")) {
				//首页
				InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
				response.println(new String(is.readAllBytes()));
				response.pushToBrowser(200);
				is.close();
				return;
			}
			Servlet servlet=WebApp.getServletFromUrl(request.getUrl());
			if (null!=servlet) {
				servlet.service(request, response);
				//关注了状态码
				System.out.println("-----------状态码:200-------------");
				response.pushToBrowser(200);
			}else{
				//错误页面
				System.out.println("-----------状态码:404-----1--------");
				InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
				if (is==null) {
					System.out.println("is is NUll");
				}
				response.println(new String(is.readAllBytes()));
				response.pushToBrowser(404);
				is.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				System.out.println("-----------状态码:500------------");
				response.println("你好我不好,我会马上好,休息一下,马上回来");
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
