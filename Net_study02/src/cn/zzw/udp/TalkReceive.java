package cn.zzw.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端: 使用面向对象封装 (加入属性/构造方法/方法)
 * @author zzw
 *
 */

public class TalkReceive implements Runnable{
	private DatagramSocket server;//r=new DatagramSocket(8889);
	private String from;
	public TalkReceive(String from,int port) {
		this.from=from;
		try {
			this.server=new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (true) {
			// 2 准备容器 封装成DdatagramPacket包裹
			byte[] container = new byte[1024];
			DatagramPacket packet = new DatagramPacket(container, 0, container.length);
			// 3 阻塞式接收包裹receive(DatagramPacket)
			try {
				server.receive(packet);   //阻塞式
				// 4 分析数据
				// byte[] getData()
				// getLength()
				byte[] datas = packet.getData();
				int len = datas.length;
				String data = new String(datas, 0, len);
				System.out.println(from+"说\t"+data);
				if (data.equals("bye")) {
					System.out.println("Going to Close");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//while
		// 5 释放资源
		server.close();
	}
}
