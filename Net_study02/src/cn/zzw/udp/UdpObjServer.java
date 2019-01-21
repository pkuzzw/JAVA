package cn.zzw.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;


/**
 * 操作引用类型  接收端
 * 1  使用DatagramSocket  指定端口 创建接收端
 * 2  准备容器 封装成DdatagramPacket包裹
 * 3  阻塞式接收包裹receive(DatagramPacket)
 * 4  分析数据
 *    byte[] getData()
 *    getLength()
 * 5  释放资源
 *    
 * @author zzw
 *
 */

public class UdpObjServer {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("接收方启动中");
		// 1 使用DatagramSocket 指定端口 创建接收端
		DatagramSocket server=new DatagramSocket(8889);
		// 2 准备容器 封装成DdatagramPacket包裹
		byte[] container=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(container, 0, container.length);
		
		// 3 阻塞式接收包裹receive(DatagramPacket)
		server.receive(packet);
		// 4 分析数据
		// byte[] getData()
		// getLength()
		byte[] datas=packet.getData();
		int len=datas.length;
		
		ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String str=ois.readUTF();
		int age=ois.readInt();
		boolean flag=ois.readBoolean();
		char ch=ois.readChar();
		
		Object strObject=ois.readObject();
		Object dateObject=ois.readObject();
		Object empObject=ois.readObject();
		
		System.out.println("str:\t"+str);
		System.out.println("char:\t"+ch);
		System.out.println("int:\t"+age);
		System.out.println("boolean:\t"+flag);
		if (strObject instanceof String) {
			System.out.println((String)strObject);
		}
		if (dateObject instanceof Date) {
			System.out.println((Date)dateObject);
		}
		if (empObject instanceof Employee) {
			System.out.println((Employee)empObject);
		}

		
		
		
		
		
		
		// 5 释放资源
		server.close();
	}

}
