package cn.zzw.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * 模拟浏览器
 * 
 * 网络爬虫的原理
 * 
 * @author zzw
 *
 */

public class SpiderTest02 {
	public static void main(String[] args) throws IOException {
		//获取URL
		URL url=new URL("https://www.dianping.com");
		//下载资源
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		//模拟浏览器的GET请求
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
//		InputStream is=url.openStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String msg=null;
		while (null!=(msg=br.readLine())) {
			System.out.println(msg);
		}
		br.close();
		//分析数据
		
		//处理数据
		
		
	}

}
