package cn.zzw.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 模拟登录 多个客户端登录请求
 * 客户端
 * 创建客户端
 * 1 建立连接:使用Socket创建客户端+服务的地址和端口
 * 2 操作 输入输出流
 * 3 释放资源
 * 
 * @author zzw
 *
 */

public class LoginMultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {


		System.out.println("客户端启动......");

		//1 建立连接:使用Socket创建客户端+服务的地址和端口
		Socket client=new Socket("localhost", 8888);
		//2 操作 输入输出流
		//发送数据
		new Send(client).send();
		new Receive(client).receive();
		//3 释放资源
		client.close();
	}
	
	
	
	//发送	内部类
	static class Send{
		private Socket client;
		private DataOutputStream dos;
		private BufferedReader console;
		private String message;

		public Send(Socket client) {
			console=new BufferedReader(new InputStreamReader(System.in));
			this.message=init();
			this.client=client;
			try {
				dos=new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		private String init(){
			try {
				System.out.println("请输入用户名:");
				String uname=console.readLine();
				System.out.println("请输入密码:");
				String upwd=console.readLine();
				return "uname="+uname+"&"+"upwd="+upwd;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "";

		}
		public void send() {
			try {
				dos.writeUTF(message);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//发送数据

				
	}//class Send
	
	
	//接收	内部类
	static class Receive{
		private Socket client;
		private DataInputStream dis;
		public Receive(Socket client) {
			this.client=client;
			try {
				dis=new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		public void receive() {
			String str;
			try {
				str = dis.readUTF();
				System.out.println("接收到的数据为:\n"+str);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
