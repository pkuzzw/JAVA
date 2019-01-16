package cn.zzw.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 *分段读取,利用缓冲字节数组  加入缓冲流
 *字节输入流 FIleInputStream
 *第一步  创建源
 *第二步  选择流
 *第三步  操作
 *第四步  释放
* @author zzw
 */

public class BufferedTest01 {
	public static void main(String[] args) {
		//第一步 创建源
		File src=new File("abc.txt");
		//第二步 选择流
		InputStream is=null;
		BufferedInputStream bis=null;//缓冲流
		int count=1;
		try {
			is=new FileInputStream(src);
			bis=new BufferedInputStream(is);//缓冲流
			byte[] flush= new byte[1024];
			int len;
			//第三步  操作
			while((len=is.read(flush))!=-1) {
				//读取之后len代表实际个数
				//读取成功,最后一次不一定是读取到5个,有可能只是len个
//				System.out.println("第"+(count++)+"次读取数据");
				//字节数组-->字符串 解码
				String str=new String(flush, 0, len);
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis!=null) {
				try {
					//第四步 释放资源
					bis.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (is!=null) {
				try {
					//第四步 释放资源
					is.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

}
