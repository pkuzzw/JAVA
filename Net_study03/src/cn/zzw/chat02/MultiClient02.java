package cn.zzw.chat02;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 在线聊天室:客户端
 * 目标:实现多个客户可正常收发多条信息
 * @author zzw
 *
 */

public class MultiClient02 {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Client启动......");
		//1 建立连接:使用Socket创建客户端+服务的地址和端口
		Socket client=new Socket("localhost", 8888);
		//2 客户端发送消息
		
		//发送一条消息
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		DataInputStream dis=new DataInputStream(client.getInputStream());
		boolean isRunning =true;
		while(isRunning) {
			String msg=console.readLine();
			dos.writeUTF(msg);
			dos.flush();
			//3 获取消息
			String str=dis.readUTF();
			System.out.println(str);
		}//while
		
		//4 释放资源
		dis.close();
		dos.close();
		client.close();
		
	}

}
