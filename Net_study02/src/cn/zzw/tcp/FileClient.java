package cn.zzw.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端上传文件
 * 创建客户端
 * 1 建立连接:使用Socket创建客户端+服务的地址和端口
 * 2 操作 输入输出流
 * 3 释放资源
 * 
 * @author zzw
 *
 */

public class FileClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("客户端启动......");
		//1 建立连接:使用Socket创建客户端+服务的地址和端口
		Socket client=new Socket("localhost", 8888);
		//2 操作 文件拷贝
		InputStream is=new BufferedInputStream(new FileInputStream("1.jpg"));
		OutputStream os=new BufferedOutputStream(client.getOutputStream());
		
		byte[] flush=new byte[1024];
		int len=-1;
		int count=1;
		while ((len=is.read(flush))!=-1) {
			System.out.println("第"+(count++)+"次读取"+len+"字节数据");
			os.write(flush, 0, len);
		}
		os.flush();
		
		//3 释放资源
		client.close();
	}

}
