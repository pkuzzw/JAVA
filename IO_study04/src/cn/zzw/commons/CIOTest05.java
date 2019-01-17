package cn.zzw.commons;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;


/**
 * 拷贝文件
 * @author zzw
 *
 */

public class CIOTest05 {
	public static void main(String[] args) throws IOException {
		//复制文件
		File src=new File("1.jpg");
		File dest=new File("2.jpg");
		//复制文件
		//FileUtils.copyFile(src, dest);
		
		
		//复制文件到目录
		//FileUtils.copyFileToDirectory(src, new File("lib"));
		
		//复制目录到目录 后者作为前者的子目录
		//FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib2"));
		
		//复制目录  复制目录内容到新目录
		//FileUtils.copyDirectory(new File("lib"), new File("lib2"));
		
		//拷贝url内容
		//FileUtils.copyURLToFile(new URL("http://benyouhuifile.it168.com/forum/201304/10/005018xwybhcxmybcyaoxs.jpg"), 
		//		new File("3.jpg"));
		String data=IOUtils.toString(new URL("http://www.163.com"), "GBK");
		System.out.println(data);
		
	}

}
