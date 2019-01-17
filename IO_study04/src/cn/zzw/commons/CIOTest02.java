package cn.zzw.commons;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;


/**
 * 读取内容
 * @author zzw
 *
 */

public class CIOTest02 {
	public static void main(String[] args) throws IOException {
		File src=new File("a.txt");
		System.out.println("----------------test common use----------");
		String msg=FileUtils.readFileToString(src,"UTF-8");
		System.out.println(msg);
		
		byte[] datas=FileUtils.readFileToByteArray(new File("a.txt"));
		System.out.println(datas.length);
		System.out.println("-------------test list--------------------");
		//逐行读取
		List<String> list=FileUtils.readLines(src, "UTF-8");
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println("-------------test iterator-----------------");
		LineIterator it=FileUtils.lineIterator(src);
		while(it.hasNext()) {
			System.out.println(it.nextLine());
		}
		
	}

}
