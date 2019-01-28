package cn.zzw.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




/**
 * 网络爬虫
 * 1 取链接
 * @author zzw
 *
 */

public class WebSpider {
	
	/**
	 * 获得url对应的网页的源码内容
	 * @param urlString
	 * @return
	 */
	public static String getURLContent(String urlString,String charset) {
		StringBuilder sb=new StringBuilder();
		BufferedReader reader=null;
		try {
			URL url=new URL(urlString);
			String tempString;
			reader=new BufferedReader(new InputStreamReader(url.openStream(),charset));
//			 Writer out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(fileAddr), "utf-8"));
			while((tempString=reader.readLine())!=null) {
				sb.append(tempString);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if (reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString() ;
	}
	public static List<String> getMactherSubstrs(String destStr,String regexStr){
		Pattern p=Pattern.compile(regexStr);//取到的超链接的地址
		Matcher m=p.matcher(destStr);
		List<String> result=new ArrayList<String>();
		while (m.find()) {
			result.add(m.group(1));
		}
		return result;
	}
	public static void main(String[] args) {
		String destStr=getURLContent("http://www.163.com","GBK");
//		System.out.println(destStr.length());
		
		//利用正则表达式查找超链接
//		Pattern p=Pattern.compile("<a[\\s\\S]+?</a>");//取到的超链接的整个内容
//		Pattern p=Pattern.compile("href=\"(.+?)\"");//取到的超链接的地址
//		Matcher m=p.matcher(destStr);
//		while (m.find()) {
//			System.out.println(m.group());
//			System.out.println(m.group(1));
//		}
		String regexStr="href=\"(.+?)\"";
		String regString="href=\"([\\w\\s./:]+?)\"";
		List<String> list=getMactherSubstrs(destStr, regString);
		for (String string : list) {
			System.out.println(string);
		}
		
		

	}

}
