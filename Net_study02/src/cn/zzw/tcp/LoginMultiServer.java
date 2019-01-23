package cn.zzw.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录 多个客户端请求
 * 熟悉流程
 * 创建服务器
 * 1 指定端口 ,使用ServerSocket创建服务器
 * 2 阻塞式等待连接 accept
 * 3 操作 输入输出流
 * 4 释放资源
 * 
 * @author zzw
 *
 */

public class LoginMultiServer {
	public static void main(String[] args) throws IOException {
		System.out.println("服务端启动.....");
		//1 指定端口 使用ServerSocket创建服务器
		ServerSocket server=new ServerSocket(8888);
		boolean isRunning =true;
		//2 阻塞式等待连接 accept
		while (isRunning) {
			 Socket client = server.accept();// 一次accept就是一个连接
             System.out.println("一个客户端建立了连接");
             new Thread(new Channel(client)).start();
		}//while
		server.close();
		
		
	
	}//main
	
	
	static class Channel implements Runnable{
		private Socket client;
		private DataInputStream dis;//输入流封装
        private DataOutputStream dos;//输出流封装
		public Channel(Socket client) {
			this.client=client;
			try {
				//输入流
				dis = new DataInputStream(client.getInputStream());
				//输出流
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				release();
			}


			
			
			
		}
		//接收数据
		private String recieve() {
			String datas;
			try {
				datas = dis.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			return datas;
		}
		//发送数据
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		//释放资源
		private void release() {
			try {
				if (dos!=null) {
					dos.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (dis!=null) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			try {
				if (client!=null) {
					client.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		@Override
		public void run() {
				String uname = "";
				String upwd = "";
				// 接收数据并分析
				String[] dataArray = recieve().split("&");
				for (String strinfo : dataArray) {
					String[] userInfo = strinfo.split("=");
					if (userInfo[0].equals("uname")) {
						System.out.println("用户名为:\t" + userInfo[1]);
						uname = userInfo[1];
					} else if (userInfo[0].equals("upwd")) {
						System.out.println("密码为:\t" + userInfo[1]);
						upwd = userInfo[1];
					}

				}
				//发送验证信息
				if (uname.equals("zzw") && upwd.equals("123")){
					send("匹配成功!");
				}else {
					send("匹配失败!");
				}
				//释放资源
				release();


			
		}
	}//class


}
