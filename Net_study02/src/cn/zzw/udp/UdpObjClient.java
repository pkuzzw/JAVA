package cn.zzw.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;


/**
 * 操作引用类型  发送端
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

public class UdpObjClient {
	public static void main(String[] args) throws IOException {
		System.out.println("发送方启动中......");
		// 1 使用DatagramSocket 指定端口 创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		// 2 准备数据 一定要转成字节数组
		// 写出
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
		// 操作数据类型+数据
		oos.writeUTF("hello,world!");
		oos.writeInt(18);
		oos.writeBoolean(true);
		oos.writeChar('C');
		oos.writeObject("谁解其中味");
		oos.writeObject(new Date());
		Employee emp = new Employee("马云", 40);
		oos.writeObject(emp);
		oos.flush();
		byte[] datas = baos.toByteArray();

		// 3 封装成DatagramPacket 需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas, datas.length, new InetSocketAddress("localhost", 8889));
		// 4 发送包裹void send(DatagramPacketp)
		client.send(packet);

		// 5 释放资源
		client.close();

	}

}

