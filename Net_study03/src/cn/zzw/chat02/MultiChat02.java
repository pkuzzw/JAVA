package cn.zzw.chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室:服务端
 * 目标:实现多个客户可正常收发多条信息
 * 问题:其他客户必须等待之前的客户退出才能继续

 * @author zzw
 *
 */

public class MultiChat02 {
	public static void main(String[] args) throws IOException {
		System.out.println("Server启动.....");
		//1 指定端口 使用ServerSocket创建服务器
		ServerSocket server=new ServerSocket(8888);
		//2 阻塞式等待连接 accept
		
		while(true) {
			Socket client=server.accept();//一次accept就是一个连接
			System.out.println("一个客户端建立了连接");
			//接收消息
			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			boolean isRunning=true;
			while (isRunning) {
				//返回消息
				String str=dis.readUTF();
				System.out.println(str);
				dos.writeUTF(str);
				dos.flush();
			}
			dis.close();
			dos.close();
			client.close();
		}//while
		//4 释放资源



	}

}
