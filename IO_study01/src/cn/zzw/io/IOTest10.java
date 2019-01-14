package cn.zzw.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 将09的例子进行封装
 * @author zzw
 *
 */

public class IOTest10 {
	
	//图片读取到字节数组
	//1 图片到程序  FileInputStream
	//2 程序到字节数组  ByteArrayOutputStream
	
	public static byte[] fileToByteArray(String filepath) {
		File src=new File(filepath);
		byte[] datas=null;
		InputStream is=null;
		ByteArrayOutputStream baos=null;
		try {
			is=new FileInputStream(src);
			baos=new ByteArrayOutputStream();
			int len=-1;
			int count=1;
			byte[] buffer=new byte[1024];		
			while((len=is.read(buffer))!=-1) {
				//每次读取len个到buffer		
				System.out.println("第"+(count++)+"次读取"+len+"字节数据");
				baos.write(buffer,0,len);
			}
			baos.flush();
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
		return null;		
	}
	//字节数组输出到图片
	//1 利用ByteArrayInputStream读取字节数组到程序中
	//2 利用FileOutputStream写出到文件
	public static void byteToFile(byte[] src,String filepath) {
		File dest=new File(filepath);
		OutputStream os=null;
		InputStream  bais=null;
		try {
			os=new FileOutputStream(dest);
			bais=new ByteArrayInputStream(src);
			int len=-1;
			byte[] buffer= new byte[1024];
			while ((len=bais.read(buffer))!=-1) {
				//读取到程序中
				os.write(buffer);			
			}
			os.flush();		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		byte[] datas=fileToByteArray("dog.jpg");
		System.out.println("datas.length="+datas.length);
		byteToFile(datas, "1.jpg");
	}

}
