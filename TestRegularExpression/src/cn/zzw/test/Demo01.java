package cn.zzw.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式在JAVA中的使用 
 */

public class Demo01 {
	public static void main(String[] args) {

		//在这个字符串:sdfkdsajkfsdjk1232ksjfdkdsjk12中匹配
		
		//表达式对象
		Pattern p=Pattern.compile("\\w+");

		//创建Matcher对象
		Matcher m=p.matcher("asdfsdf1#23");
		
//		boolean result=m.matches();//尝试将整个字符序列与该模式进行匹配
//		System.out.println(result);
//		boolean result2=m.find();//该方法扫描输入的序列,查找与该模式匹配的下一个子序列

		while (m.find()) {
			System.out.println(m.group());
		}
		//通过find方法找到后,返回找到的内容  group()
		// group group(0)匹配整个表达式的子字符串
		
		
	}


	
}
