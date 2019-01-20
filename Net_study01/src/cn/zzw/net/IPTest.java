package cn.zzw.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP的作用: 定位一个节点  InetAddress
 * 1 getLocalHost  获取本机地址
 * 2 getByName 根据域名解析地址
 * 3 getByName 根据IP地址解析IP地址
 * 
 * 两个方法
 * getHostAddress()返回地址
 * getHostName()返回名字
 * 
 * @author zzw
 *
 */

public class IPTest {
	//
	
	public static void main(String[] args) throws UnknownHostException {
		//使用getLocalHost方法创建InetAddress对象
		System.out.println("-------使用getLocalHost方法创建InetAddress对象-----------");
		InetAddress addr=InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		
		//根据域名得到InetAddress对象
		System.out.println("-------根据域名得到InetAddress对象-----------");
		addr=InetAddress.getByName("www.baidiu.com");
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		
		//根据IP得到InetAddress对象
		System.out.println("-------根据IP得到InetAddress对象-----------");
		addr=InetAddress.getByName("123.56.138.186");
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());//输出的是ip而不是域名 如果这个IP地址不存在或者DNS不允许进行IP和域名的映射,getHostName方法就直接返回这个IP地址
		
	}

}
