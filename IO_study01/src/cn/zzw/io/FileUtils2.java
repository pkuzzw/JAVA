package cn.zzw.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1 封装拷贝
 * 2 封装释放资源
 * @author zzw
 *
 */

public class FileUtils2 {
	/**
	 * 对接输入输出流
	 * InputStream
	 * OutputStream
	 * @param is
	 * @param os
	 */
	
	public static void main(String[] args) {
		//文件到文件
		try {
			InputStream is=new FileInputStream("1.jpg");
			OutputStream os=new FileOutputStream("2.jpg");
			CopyFile(is, os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		byte[] datas=null;
		//文件到字节数组
		try {
			InputStream is=new FileInputStream("1.jpg");
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			CopyFile(is, os);
			datas=os.toByteArray();
			System.out.println("datas.length="+datas.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//字节数组到文件
		try {
			ByteArrayInputStream bais=new ByteArrayInputStream(datas);
			OutputStream os=new FileOutputStream("11.jpg");
			CopyFile(bais, os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 对接输入输出流
	 * try ...with...resource
	 * try里面: 流的声明
	 * @param is
	 * @param os
	 */
	public static void CopyFile(InputStream is,OutputStream os) {
		try(is;os) {
			byte[] flush = new byte[1024 * 10];
			int len = -1;
			int count = 1;
			while ((len = is.read(flush)) != -1) {
				System.out.println("第" + (count++) + "次读取\t" + "读取了" + len + "个字节");
				os.write(flush, 0, len);// 写入到文件中去
				os.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	



}
