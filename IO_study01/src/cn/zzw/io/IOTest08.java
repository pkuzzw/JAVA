package cn.zzw.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * 字节数组输出流 ByteArrayOutputStream
 *第一步  创建源   这里不需要指定源头,因为直接输出到内存中去,由程序内部维护,privated byte[] buf;//缓冲区
 *																privated int count;//缓冲区中有效字节的数目							
 *第二步  选择流    不关联源
 *第三步  操作     toByteArray()方法
 *第四步  释放      可以不用释放
 *@author zzw
 */

public class IOTest08 {
	public static void main(String[] args) {
		//第一步 创建源,因为ByteArrayOutputStream写出的直接到内存,不用指定源
		
		//第二步 选择流,因为要用到子类的方法toByteArray(),故这里不用多态
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		
		//操作:首先将一个字符串的byte数组写出到内存
		String str="Show me the code, Talk is cheap";
        byte[] data=str.getBytes();
        
        try {
			baos.write(data);
			baos.flush();
		//验证输出的数据是否正确,将数据从内存中从新读取出来,利用方法toByteArray()
			byte[] test=baos.toByteArray();
			System.out.println("The size:\t"+baos.size()+"\nThe String:\t"+new String(test));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
