package cn.zzw.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *第一个测试IO程序
 *第一步  创建源
 *第二步  选择流
 *第三步  操作
 *第四步  释放
 * @author zzw
 */

public class IOTest01 {
	public static void main(String[] args) {
		//第一步 创建源
		File srcFile=new File("abc.txt");
		//第二步 选择流
		InputStream insStream= null;
		//第三步 操作
		try {
			insStream=new FileInputStream(srcFile);
			int data=insStream.read();
			System.out.println("data="+data+" character="+(char)data);
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
