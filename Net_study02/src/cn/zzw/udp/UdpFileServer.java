package cn.zzw.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;



/**
 * 文件存储  接收端
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

public class UdpFileServer {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("接收方启动中");
		// 1 使用DatagramSocket 指定端口 创建接收端
		DatagramSocket server=new DatagramSocket(9999);
		// 2 准备容器 封装成DdatagramPacket包裹
		byte[] container=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(container, 0, container.length);
		
		// 3 阻塞式接收包裹receive(DatagramPacket)
		server.receive(packet);
		// 4 分析数据
		// byte[] getData()
		// getLength()
		byte[] temp=packet.getData();
		int len=packet.getLength();
		System.out.println("length=\t"+len);
		IOUtils.byteToFile(temp, "3_copy.jpg");
		
		
		
		// 5 释放资源
		server.close();
	}

}
