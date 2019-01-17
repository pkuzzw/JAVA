package cn.zzw.commons;

import java.io.File;

import org.apache.commons.io.FileUtils;

/**
 * 统计文件和文件夹的大小
 * @author zzw
 *
 */

public class CIOTest01 {
	public static void main(String[] args) {
		//文件大小
		long len=FileUtils.sizeOf(new File("abc.txt"));
		System.out.println("len:\t"+len);
		
		//目录大小
		len=FileUtils.sizeOf(new File("/home/zzw/eclipse-workspace/IO_study04"));
		System.out.println("len:\t"+len);

		
	}

}
