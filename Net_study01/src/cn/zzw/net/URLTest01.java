package cn.zzw.net;

import java.io.IOException;
import java.net.URL;

/**
 * URL:统一资源定位符 互联网三大基石之一(http html)区分资源
 * 1	协议
 * 2	存放资源的主机域名
 * 3	端口号:默认80
 * 4	资源文件名
 * http://www.baidu.com:80/index.html?uname=zzw&age=18#a 
 * @author zzw
 *
 */

public class URLTest01 {
	public static void main(String[] args) throws IOException {
		URL url=new URL("http://www.baidu.com:80/index.html?uname=zzw&age=18#a");
		
		//获取四个值
		
		//1协议
		System.out.println("协议getProtocol():\t"+url.getProtocol());
		//主机域名
		System.out.println("主机域名getHost():\t"+url.getHost());
		//端口号
		System.out.println("端口号getPort():\t"+url.getPort());
		//资源文件名
		System.out.println("请求资源getFile():\t"+url.getFile());
		System.out.println("请求资源getPath():\t"+url.getFile());
		
		//参数和锚点
		System.out.println("参数getQuery():\t"+url.getQuery());
		//锚点
		System.out.println("锚点getRef():\t"+url.getRef());

	}

}
