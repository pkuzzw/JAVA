package cn.zzw.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 使用FileInputStream 和FileOutputStream实现文件的复制功能 第一步 创建源 第二步 选择流 第三步 操作 第四步 释放
 * 
 * @author zzw
 */

public class Copy {

	public static void CopyFile(String srcPath, String destPath) {
		// 第一步 创建源
//				File src=new File("test.jpg");
//				File dest=new File("test_copy.jpg");
		File src = new File(srcPath);
		File dest = new File(destPath);
		// 第二步 选择流
		FileOutputStream os = null;
		FileInputStream is = null;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);

			// 操作
			// 利用FileInputStream将文件转为字节数组
			// 利用FileOutputStream将字节数组写入文件
			byte[] flush = new byte[1024 * 10];
			int len = -1;
			int count = 1;
			while ((len = is.read(flush)) != -1) {
				// 将文件编码成字节数据读取到缓冲数组flush,读取成功的位数为len
				System.out.println("第" + (count++) + "次读取\t" + "读取了" + len + "个字节");
				os.write(flush, 0, len);// 写入到文件中去
				os.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 第四步 释放资源 分别关闭,先打开的后关闭
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					is.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("Test Start");
		CopyFile("src/cn/zzw/io/Copy.java", "copy.txt");

		
	}
}
