package cn.zzw.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 模拟登录 双向
 * 客户端
 * 创建客户端
 * 1 建立连接:使用Socket创建客户端+服务的地址和端口
 * 2 操作 输入输出流
 * 3 释放资源
 * 
 * @author zzw
 *
 */

public class LoginTwoWayClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("客户端启动......");
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名:");
		String uname=console.readLine();
		System.out.println("请输入密码:");
		String upwd=console.readLine();


		//1 建立连接:使用Socket创建客户端+服务的地址和端口
		Socket client=new Socket("localhost", 8888);
		//2 操作 输入输出流
		//发送数据
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		
		dos.writeUTF("uname="+uname+"&"+"upwd="+upwd);
		dos.flush();
		
		//接收数据
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String str=dis.readUTF();
		System.out.println("服务端发来的数据为:\t"+str);
		
		//3 释放资源
		dos.close();
		client.close();
	}

}
