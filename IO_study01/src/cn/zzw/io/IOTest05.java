package cn.zzw.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


/**
 * 测试文件字符流,与字节流相比,以字符为单位对数据进行处理
 * Reader:通过字符的方式读取文件  仅适合字符文件
 * Writer:通过字节的方式写出或者追加数据到文件中  仅适合字符文件
 *第一步  创建源
 *第二步  选择流
 *第三步  操作
 *第四步  释放
 * @author zzw
 *
 */

public class IOTest05 {
	public static void main(String[] args) {
		System.out.println("Test Reader &  Writer");
		File file=new File("abc.txt");
		Reader ireader=null;
		try {
			ireader=new FileReader(file);
			int len=-1;
			char[] flush= new char[5];
			while ((len=ireader.read(flush))!=-1) {
				//read方法返回的是一个字符
				//这个时候存在flush里面的就是字符数字,可以解码后直接输出
				System.out.println(new String(flush,0,len));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ireader!=null) {
				try {
					ireader.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
	}

}
