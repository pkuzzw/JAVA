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
	private int folderNumber;//文件个数
	private int filenumbers;
	public  FileLength(String path) {
		this.path=path;
		this.folderNumber=-1;
		this.src=new File(this.path);
		getLength(this.src);
		
	}
	
	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public int getFolderNumber() {
		return folderNumber;
	}

	public void setFolderNumber(int folderNumber) {
		this.folderNumber = folderNumber;
	}

	public int getFilenumbers() {
		return filenumbers;
	}

	public void setFilenumbers(int filenumbers) {
		this.filenumbers = filenumbers;
	}

	private void getLength(File srcFile) {
		if (null!=srcFile && srcFile.exists()) {
			if(srcFile.isFile()) {
				this.filenumbers++;
				this.length+=srcFile.length();
			} else if (srcFile.isDirectory()) {
				this.folderNumber++;
				for (File file : srcFile.listFiles()) {
					getLength(file);
				}
			}	
			
		}
	
	} 
	
	public static void main(String[] args) {
       FileLength test1=new FileLength("/home/zzw/eclipse-workspace/MyPro01/src/cn/zzw");
	   System.out.println(test1.getLength());
	   System.out.println("folderNumber="+test1.getFolderNumber());
	   System.out.println("filenumbers="+test1.getFilenumbers());
	   
		
		
	}
	
}
