package cn.zzw.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * 创建客户端
 * 1 建立连接:使用Socket创建客户端+服务的地址和端口
 * 2 操作 输入输出流
 * 3 释放资源
 * 
 * @author zzw
 *
 */

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("客户端启动......");
		//1 建立连接:使用Socket创建客户端+服务的地址和端口
		Socket client=new Socket("localhost", 8888);
		//2 操作 输入输出流
		//发送数据
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF("Hello");
		
		dos.flush();
		
		
		//3 释放资源
		dos.close();
		client.close();
	}

}
