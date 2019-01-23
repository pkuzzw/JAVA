package cn.zzw.chat03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室:服务端
 * 目标:封装实现多个客户可正常收发多条信息
 * 问题:
 *   1 代码太多不好维护
 *   2 客户端读写没分开 必须先写后读
 * @author zzw
 *
 */

public class ThreadMultiChat {
	public static void main(String[] args) throws IOException {
		System.out.println("Server启动.....");
		//1 指定端口 使用ServerSocket创建服务器
		ServerSocket server=new ServerSocket(8888);
		//2 阻塞式等待连接 accept
		String[] names= {"小明","小华","小红","小王","小刚"};
		while(true) {
			Socket client=server.accept();//一次accept就是一个连接
			String client_name=names[(int) Math.floor(Math.random()*5)];
			System.out.println("一个客户端建立了连接,客户名字为;\t"+client_name);
			new Thread(new Channel(client)).start();
		}
	}//main
	
	
	//一个客户代表一个channel
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		public Channel(Socket client) {
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos=new DataOutputStream(client.getOutputStream());
				isRunning=true;
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("出错了,不玩了!!!");
				release();
			}
			
		}
		
		@Override
		public void run() {
			while(isRunning) {
				String msg=receive();
				if (msg!=null) {//消息不为空
					send(msg);
				}
			}
		}
		
		//接收消息
		private String receive() {
			String str = null;
			try {
				str = dis.readUTF();
				System.out.println(str);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("private String receive Wrong!~");
				release();
			}
			return str;
		}
		//发送消息
		private void send(String str) {
			try {
				dos.writeUTF(str);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("private void send() Wrong!~");
				release();
			}
		}
		//释放资源
		private void release() {
			this.isRunning=false;
			ChatUtils.close(dis,dos,client);

		}
		
	}

}
