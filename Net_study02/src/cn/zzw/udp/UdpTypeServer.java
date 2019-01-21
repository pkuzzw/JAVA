package cn.zzw.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP  接收端
 * 1  使用DatagramSocket  指定端口 创建接收端
 * 2  准备容器 封装成DdatagramPacket包裹
 * 3  阻塞式接收包裹receive(DatagramPacket)
 * 4  分析数据 将字节数组还原为对应的类型
 *    byte[] getData()
 *    getLength()
 * 5  释放资源
 *    
 * @author zzw
 *
 */

public class UdpTypeServer {
	public static void main(String[] args) throws IOException {
		System.out.println("接收方启动中");
		// 1 使用DatagramSocket 指定端口 创建接收端
		DatagramSocket server=new DatagramSocket(8889);
		// 2 准备容器 封装成DdatagramPacket包裹
		byte[] container=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(container, 0, container.length);
		
		// 3 阻塞式接收包裹receive(DatagramPacket)
		server.receive(packet);
		// 4 分析数据 将字节数组还原为对应的类型
		// byte[] getData()
		// getLength()
		byte[] datas=packet.getData();
		int len=datas.length;
		
		//读取数据
		DataInputStream dis=new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //顺序与写出一直
		String msg=dis.readUTF();
		int a=dis.readInt();
		boolean flag=dis.readBoolean();
		char ch=dis.readChar();
		System.out.println("UTF:\t"+msg);
		System.out.println("int:\t"+a);
		System.out.println("flag:\t"+flag);
		System.out.println("char:\t"+ch);
		
		
		// 5 释放资源
		server.close();
	}

}
