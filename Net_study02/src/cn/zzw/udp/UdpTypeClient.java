package cn.zzw.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 基本类型  发送端
 * 1  使用DatagramSocket  指定端口 创建发送端
 * 2  将基本类型  --->字节数组
 * 3  封装成DatagramPacket  需要指定目的地
 * 4  发送包裹void send(DatagramPacketp)
 * 5  释放资源
 *    byte[] getData()
 *    getLength()
 *    
 * @author zzw
 *
 */

public class UdpTypeClient {
	public static void main(String[] args) throws IOException {
		System.out.println("发送方启动中......");
		// 1 使用DatagramSocket 指定端口 创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		// 2 将基本类型 --->字节数组
		
		//准备写出
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream os=new DataOutputStream(new BufferedOutputStream(baos));
		//操作数据类型
		os.writeUTF("编码辛酸泪");
		os.writeInt(2);
		os.writeBoolean(true);
		os.writeChar('D');
		os.flush();
		byte[] datas=baos.toByteArray();
		// 3 封装成DatagramPacket 需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas, datas.length, new InetSocketAddress("localhost", 8889));
		// 4 发送包裹void send(DatagramPacketp)
		client.send(packet);

		// 5 释放资源
		client.close();

	}

}
