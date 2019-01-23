package cn.zzw.chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室:服务端
 * 目标:实现一个客户可正常收发单条信息
 * @author zzw
 *
 */

public class Chat {
	public static void main(String[] args) throws IOException {
		System.out.println("Server启动.....");
		//1 指定端口 使用ServerSocket创建服务器
		ServerSocket server=new ServerSocket(8888);
		//2 阻塞式等待连接 accept
		Socket client=server.accept();//一次accept就是一个连接
		System.out.println("一个客户端建立了连接");
		
		
		//接收消息
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String str=dis.readUTF();
		System.out.println(str);
		
		//返回消息
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF(str);
		dos.flush();
		
		//4 释放资源
		dis.close();
		dos.close();
		client.close();


	}

}
