package cn.zzw.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送方:使用面向对象封装 (加入属性/构造方法/方法)
 * @author zzw
 *
 */

public class TalkSend implements Runnable{
	private DatagramSocket client;
	private BufferedReader reader;
	private String toIP;
	private int toPort;
	public TalkSend(int port,String toIP,int toPort) {
		this.toIP=toIP;
		this.toPort=toPort;
		try {
			this.client = new DatagramSocket(port);
			reader=new BufferedReader(new InputStreamReader(System.in));

		} catch (SocketException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		while (true) {
			String data = null;
			try {
				data = reader.readLine();
				byte[] datas = data.getBytes();
				// 3 封装成DatagramPacket 需要指定目的地
				DatagramPacket packet = new DatagramPacket(datas, datas.length, 
						new InetSocketAddress(this.toIP, this.toPort));
				// 4 发送包裹void send(DatagramPacketp)
				client.send(packet);
				if (data.equals("bye")) {
					System.out.println("Going to Close");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}//while
		// 5 释放资源
		client.close();
		
	}
}
