package cn.zzw.commons;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;

/**
 * 列出子孙级
 * 不需要递归,直接拿来使用
 * @author zzw
 *
 */

public class CIOTest03 {
	public static void main(String[] args) {
		
		Collection<File> files=FileUtils.listFiles(new File("/home/zzw/eclipse-workspace"), 
				EmptyFileFilter.NOT_EMPTY, null);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("--------------------");
		Collection<File> files1=FileUtils.listFiles(new File("/home/zzw/eclipse-workspace"),
				EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
		for (File file : files1) {
			System.out.println(file.getAbsolutePath());
		}
		//文件大小
		long len=FileUtils.sizeOf(new File("abc.txt"));
		System.out.println("len:\t"+len);
		
		//目录大小
		len=FileUtils.sizeOf(new File("/home/zzw/eclipse-workspace/IO_study04"));
		System.out.println("len:\t"+len);

		
	}

}
