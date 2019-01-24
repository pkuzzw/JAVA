package cn.zzw.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组输入流ByteArrayInputStream
 * ByteArrayInputStream里面包含一个内部缓冲区,用来存储读取到的字节,内部计数器跟踪由read方法提供的下一字节
 *第一步  创建源  源头是字节数组,不要太大
 *第二步  选择流
 *第三步  操作
 *第四步  释放    不需要释放
 *@author zzw
 */

public class IOTest07 {
	public static void main(String[] args) {
		//第一步 创建源
		//第二步 选择流
		InputStream bi=null;
		try {
			//操作
			String str="你好,这是JAVA程序";
			byte[] data=str.getBytes();
			bi=new ByteArrayInputStream(data);
			byte[] buffer=new byte[10];
			int len=-1;
			while((len=bi.read(buffer))!=-1) {
				String str1=new String(buffer,0,len);
				System.out.println(str1);
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//不需要释放
	}
}
