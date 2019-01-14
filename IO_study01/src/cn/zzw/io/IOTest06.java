package cn.zzw.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 测试Writer
 * 第一步 创建源
 * 第二步 选择流
 * 第三步 操作
 * 第四步 释放资源
 * @author zzw
 *
 */
public class IOTest06 {
	public static void main(String[] args) {
		File file=new File("dest.txt");
		Writer ow=null;
		try {
			ow=new FileWriter(file);
			//利用Writer数组输出时,可以直接输出字符串数组
			String str=new String("Hello,你还好吗,我的朋友\n");
			//第一种方法,利用char[]字符数组进行写出
			char[] buffer= str.toCharArray();//此处与FileOutputStream不同,之前直接转换为byte[]数组
											 //利用getBytes()方法
										     //字符串--->字符数组  以字符为单位,之前是字符串转为字节数组
			ow.write(buffer);
			ow.flush();		
			//第二种方法,直接利用String进行输出
			String str1="\n测试第二种方法写出到文件";
			ow.write(str1);
			ow.flush();
			//第三种方法,利用appen(Charsequence seq)添加
			ow.append(str1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ow!=null) {
				try {
					ow.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
