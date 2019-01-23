package cn.zzw.chat05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * 在线聊天室:服务端
 * 目标:私聊
 * 
 * @author zzw
 *
 */

public class Chat {
	private static CopyOnWriteArrayList<Channel>   allclient=new CopyOnWriteArrayList<Channel>();
	public static void main(String[] args) throws IOException {
		System.out.println("Server启动.....");
		//1 指定端口 使用ServerSocket创建服务器
		ServerSocket server=new ServerSocket(8888);
		//2 阻塞式等待连接 accept
		while(true) {
			Socket client=server.accept();//一次accept就是一个连接
			System.out.println("一个客户端建立了连接,客户名字为;\t");
			Channel channel=new Channel(client);
			allclient.add(channel);//交给容器来管理所有的成员
			new Thread(channel).start();
		}
	}//main
	
	
	//一个客户代表一个channel
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		private String name;
		public Channel(Socket client) {
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos=new DataOutputStream(client.getOutputStream());
				isRunning=true;
				//获取名称
				this.name=receive();
				//欢迎你的到来
				this.send("欢迎你的到来");
				sendOthers("欢迎"+this.name+"来到了聊天室",true);
				
			} catch (IOException e) {
				System.out.println("--------------------1----------------------------");
				release();
			}
			
		}
		
		@Override
		public void run() {
			while(isRunning) {
				String msg=receive();
				if (msg!=null) {//消息不为空
					//send(msg);
					sendOthers(msg,false);
				}
			}
		}
		
		//接收消息
		private String receive() {
			String str = null;
			try {
				str = dis.readUTF();
			} catch (IOException e) {
				System.out.println("-----------------4------------------~");
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
				System.out.println("----------------------3------------------------");
				release();
			}
		}
		//群聊  获取自己的消息,发给其他人
		//私聊: 约定数据个事: @xxx:msg
		private void sendOthers(String str,boolean isSys) {
			boolean isSecret=str.startsWith("@");
			if (isSecret) {//私聊
				int index=str.indexOf(":");
				//获取目标和数据
				String targetName=str.substring(1,index);
				str=str.substring(index+1);
				for (Channel channel : allclient) {
					if (channel.name.equals(targetName)) {//目标找到
						channel.send(this.name+"悄悄的对你说"+str);
					}
				}
				
			}else {//群聊或者系统消息
				for(Channel channel : allclient) {
					if (channel == this) {
						continue;
					}
					if (!isSys) {
						channel.send(this.name+"对所有人说:"+str);//群聊消息
					} else {
						channel.send(str);//系统消息
					}
				}
			}//else secret
		}
		//释放资源
		private void release() {
			this.isRunning=false;
			ChatUtils.close(dis,dos,client);
			//退出
			allclient.remove(this);
			sendOthers(this.name+"离开大家庭", true);

		}
		
	}

}
