package cn.zzw.chat03;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 在线聊天室:客户端
 * 目标:封装实现多个客户可正常收发多条信息
 * @author zzw
 *
 */

public class ThreadMultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Client启动......");
		//1 建立连接:使用Socket创建客户端+服务的地址和端口
		Socket client=new Socket("localhost", 8888);
		//2 客户端发送消息
		new Thread(new Send(client)).start();
		
		new Thread(new Receive(client)).start();
		
		
	}

}
