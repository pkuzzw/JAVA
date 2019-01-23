package cn.zzw.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录 双向
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

public class LoginTwoWayServer {
	public static void main(String[] args) throws IOException {
		System.out.println("服务端启动.....");
		//1 指定端口 使用ServerSocket创建服务器
		ServerSocket server=new ServerSocket(8888);
		//2 阻塞式等待连接 accept
		Socket client=server.accept();//一次accept就是一个连接
		System.out.println("一个客户端建立了连接");
		//3操作 输入输出流
		//接收数据
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String str=dis.readUTF();
		System.out.println("客户端发来的数据为:\t"+str+"\n分析数据ing.....");
		String uname="";
		String upwd="";
		//分析数据
		String[] dataArray=str.split("&");
		for (String strinfo : dataArray) {
			String[] userInfo=strinfo.split("=");
			if (userInfo[0].equals("uname")) {
				System.out.println("用户名为:\t"+userInfo[1]);
				uname=userInfo[1];
			}else if (userInfo[0].equals("upwd")) {
				System.out.println("密码为:\t"+userInfo[1]);
				upwd=userInfo[1];
			}
			
		}
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		if (uname.equals("zzw") && upwd.equals("123")) {//成功
			dos.writeUTF("匹配成功!");
			dos.flush();
			
		} else {//失败
			dos.writeUTF("匹配失败!");
			dos.flush();
			
		}
		//4释放资源
		dis.close();
		client.close();
		
		server.close();
		
		
		
	}

}
