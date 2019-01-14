/**
 * 利用While数组读取一整个文件
 */


package cn.zzw.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 第一个测试IO程序
 * 
 * 
 * @author zzw
 *
 */

public class IOTest02 {
	public static void main(String[] args) {
		//第一步 创建源
		File srcFile=new File("abc.txt");
		//第二步 选择流
		InputStream insStream= null;
		//第三步 操作
		try {
			insStream=new FileInputStream(srcFile);
			int len;
			while ((len=insStream.read())!=-1) {
				System.out.println((char)len);				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//第四步 释放资源
			if (srcFile != null) {
				try {
					insStream.close();				
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

}
