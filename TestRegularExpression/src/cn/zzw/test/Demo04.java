package cn.zzw.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式在JAVA中的使用 
 */

public class Demo04 {
	public static void main(String[] args) {

		String str="a,b,c";
		String[] arrs=str.split(",");
		System.out.println(Arrays.toString(arrs));
		

		//按照正则表达式进行分割
		String str1="a232b1212c11d";
		String[] arrs1=str1.split("\\d+");
		System.out.println(Arrays.toString(arrs1));
		
		
	}


	
}
