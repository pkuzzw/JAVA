package cn.zzw.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * UDP  发送端
 * 1  使用DatagramSocket  指定端口 创建发送端
 * 2  准备数据 一定要转成字节数组
 * 3  封装成DatagramPacket  需要指定目的地
 * 4  发送包裹void send(DatagramPacketp)
 * 5  释放资源
 *    byte[] getData()
 *    getLength()
 *    
 * @author zzw
 *
 */

public class UdpClient {
	public static void main(String[] args) throws IOException {
		System.out.println("发送方启动中......");
		// 1 使用DatagramSocket 指定端口 创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		// 2 准备数据 一定要转成字节数组
		String data = "中国最牛程序员";
		byte[] datas = data.getBytes();
		// 3 封装成DatagramPacket 需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas, datas.length, new InetSocketAddress("localhost", 8889));
		// 4 发送包裹void send(DatagramPacketp)
		client.send(packet);

		// 5 释放资源
		client.close();
		
	}

}
