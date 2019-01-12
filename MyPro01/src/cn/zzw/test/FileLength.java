package cn.zzw.test;

import java.io.File;

/**
 * 统计文件夹的大小
 * 输入:文件夹名字
 * 输出:文件夹字节数大小
 * @author zzw
 *
 */

public class FileLength {
	private long length;
	private String path;
	private File src;
	public  FileLength(String path) {
		this.path=path;
		this.src=new File(this.path);
		getLength(this.src);
		
	}
	private void getLength(File srcFile) {
		if (null!=srcFile && srcFile.exists()) {
			if(srcFile.isFile()) {
				this.length+=srcFile.length();
			} else if (srcFile.isDirectory()) {
				for (File file : srcFile.listFiles()) {
					getLength(file);
				}
			}	
			
		}
	
	} 
	
	public static void main(String[] args) {
		String filepath="/home/zzw/eclipse-workspace";
	   String file1path="/home/zzw/eclipse-workspace/MyPro01";
//		File srcFile= new File(filepath);
	   FileLength test1=new FileLength(filepath);
	   System.out.println(test1.length);
	   
		
		
	}
	
}
