/**
测试递归调用子文件夹
 * 
 */
package cn.zzw.test;

import java.io.File;
import java.io.IOException;

/**
 * @author zzw
 *
 */
public class DirDemo04 {
	public static void main(String[] args) {
		File src=new File("/home/zzw/eclipse-workspace/MyPro01");
		printName(src,0);		
	}
	public static void printName(File srcFile,int deep) {
		for (int i = 0; i < deep; i++) {
			System.out.print("-");
		}
		System.out.println(srcFile.getName());
		if (null==srcFile || !srcFile.exists()) {
			return;
		} else if (srcFile.isDirectory()) {
			for (File s : srcFile.listFiles()) {
				printName(s,deep+1);
			}			
		} 
	}

}
