package cn.zzw.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
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

public class Server {
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
		System.out.println("客户端发来的数据为:\t"+str);
		//4释放资源
		
		
		dis.close();
		client.close();
		
		server.close();
		
		
		
	}

}
