package cn.zzw.tcp;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端存储文件
 * 创建服务器
 * 1 指定端口 ,使用ServerSocket创建服务器
 * 2 阻塞式等待连接 accept
 * 3 操作 输入输出流
 * 4 释放资源
 * 
 * @author zzw
 *
 */

public class FileServer {
	public static void main(String[] args) throws IOException {
		System.out.println("服务端启动.....");
		//1 指定端口 使用ServerSocket创建服务器
		ServerSocket server=new ServerSocket(8888);
		//2 阻塞式等待连接 accept
		Socket client=server.accept();//一次accept就是一个连接
		System.out.println("一个客户端建立了连接");
		//3操作 
		//接收到文件,进行存储
		//先解析出来数据然后进行存储
		DataInputStream dis=new DataInputStream(client.getInputStream());
		int len=-1;
		byte[] buffer= new byte[1024];
		int count=1;
		OutputStream os=new FileOutputStream(new File("tcp_copy.jpg"));
		while((len=dis.read(buffer))!=-1) {
			System.out.println("byteToFile\t第"+(count++)+"次读取了"+len+"个数据");
			os.write(buffer);	
		}
		os.flush();
		//4释放资源
		os.close();
		dis.close();
		client.close();
		server.close();
		
		
		
	}

}
