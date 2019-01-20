package cn.zzw.net;

import java.net.InetSocketAddress;

/**
 * 端口 Port
 * 1  区分软件
 * 2  2个字节 0-65535
 * 3  同一个协议端口不能冲突
 * 4  定义端口,越大越好
 * 
 * 
 * 父类  SocketAddress
 * 
 *  构造器
 *  1 new InetSocketAddress(域名|地址:端口)
 *  方法
 *  getAddress()
 *  getPort()
 *  getHostName()
 *  

 * @author zzw
 *
 */

public class PortTest {
	
	public static void main(String[] args) {
		
		//包含端口
		InetSocketAddress socketAddress=new InetSocketAddress("127.0.0.1",8080);
		InetSocketAddress socketAddress1=new InetSocketAddress("localhost",9000);
		
		System.out.println(socketAddress.getHostName());
		System.out.println(socketAddress1.getAddress());

	}

}
