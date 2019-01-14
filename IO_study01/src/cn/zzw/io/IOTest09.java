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
 * 利用FileInputStream FileOutputStream ByteArrayInputStream ByteArrayOutputStream
 * 实现文件的复制
 *第一步  创建源   						
 *第二步  选择流   
 *第三步  操作     toByteArray()方法
 *第四步  释放      可以不用释放
 *@author zzw
 */

public class IOTest09 {
	public static void main(String[] args) {
		//第一步 创建源 只需要创建文件的源头即可,ByteArrayInputStream以及ByteArrayOutputStream不需要创建源头
		File srcfile=new File("dog.jpg");
		File destFile= new File("dog_copy.jpg");
		//第二步,选择流,这里需要使用四个流 FileInputStream
		//							 FileOutputStream
		//							 ByteArrayInputStream
		//							 ByteArrayOutputStream

		InputStream is=null;
		OutputStream os=null;
		InputStream bais=null;
		ByteArrayOutputStream baos=null;
		//第三步 操作,
		//3.1	利用FileInputStream从文件中读取数据得到字节数据
		//3.2	利用ByteArrayOutputStream将第3.1得到的字节数组写出到内存
		//3.3	利用ByteArrayInputStream将3.2写入到内存的字节数组读取到程序
		//3.4	利用FileOutputStream将字节数组写出到文件
		try {
			is=new FileInputStream(srcfile);
			os=new FileOutputStream(destFile);
			byte[] buffer=new byte[1024*5];
			int count=1;
			int len=-1;
			byte[] flush=null;
			while ((len=is.read(buffer))!=-1) {
				//从文件中读取到len个数据到buffer中
				System.out.println("第"+(count++)+"次读取"+len+"字节数据");
				baos=new ByteArrayOutputStream();//
				baos.write(buffer);
				flush=baos.toByteArray();
				bais=new ByteArrayInputStream(flush);
				bais.read(flush);
				os.write(flush,0,len);
			}
			baos.flush();
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
