package cn.zzw.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件字节输出流 FileOutputStream
 *第一步  创建源
 *第二步  选择流
 *第三步  操作
 *第四步  释放
 *@author zzw
 */

public class BufferedTest02 {
	public static void main(String[] args) {
		//第一步 创建源
		File file=new File("dest.txt");
		//第二步 选择流
		FileOutputStream os=null;
		try {
			//第三步  操作
			os=new FileOutputStream(file,true);
			
			//编码,字符-->字节数组
			//FileOutputStream进行存储的时候是存的字节数组
			String str="你好啊,你在干啥啊\n";
			byte[] data=str.getBytes();
			os.write(data);
			os.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//第四步 释放资源
			if (os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
