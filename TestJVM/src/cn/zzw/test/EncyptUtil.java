package cn.zzw.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 加密工具类
 * @author zzw
 *
 */

public class EncyptUtil {
	public static void encrypt(File src,File dest) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream(src);
			fos=new FileOutputStream(dest);

			int len=-1;
			while((len=fis.read())!=-1) {
				fos.write(len^0xff);//取反操作
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (null!=fis) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (null!=fos) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		File destFile=new File("/home/zzw/code1/helloworld.class");
		File srcFile=new File("/home/zzw/code/helloworld.class");
		try {
			destFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		encrypt(srcFile, destFile);
		
	}

}
