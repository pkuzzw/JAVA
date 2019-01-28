package cn.zzw.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式在JAVA中的使用 
 */

public class Demo02 {
	public static void main(String[] args) {
		//表达式对象
		Pattern pattern=Pattern.compile("([a-z]+)([0-9]+)");
		//创建Matcher对象
		Matcher matcher=pattern.matcher("aa232**ssd445*sds223");
		
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
		
		//group () 整个字符串
		//group(1) 分组1

		
	}


	
}
