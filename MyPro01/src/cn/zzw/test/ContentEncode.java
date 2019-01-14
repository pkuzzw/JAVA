package cn.zzw.test;

import java.io.UnsupportedEncodingException;

/**
 * 测试字符串编码方法getBytes()
 * 字符串-->字节   编码
 * 字节-->字符串   解码
 * @author zzw
 *
 */

public class ContentEncode {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msgString="性命使命生命";
		//编码,使用字节数字
		System.out.println("--------Test UTF-8-------------------");

		byte[] datas=msgString.getBytes();//默认使用project的字符集
		//解码
		System.out.println("UTF-8 = "+datas.length);
		System.out.println("Decoding: string="+new String(datas));
		System.out.println("Decoding: string="+new String(datas,"UTF-16LE"));
		
		
		System.out.println("Decoding: string="+new String(datas,"UTF-16LE"));
		
		//乱码的原因
		//1 字节数不够
		//2 字符集不统一

		
		
		
		//编码成其他字符集
		
		
		
		System.out.println("--------Test UTF-16LE-------------------");
		datas=msgString.getBytes("UTF-16LE");
		System.out.println("UTF-16LE = "+datas.length);
		

		System.out.println("--------Test UTF-16---------------------");
		System.out.println("UTF-16 = "+datas.length);
		
		System.out.println("--------Test GBK------------------------");
		System.out.println("GBK = "+datas.length);
		
		
	}

}
