package cn.zzw.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;

/**
 * 封装请求协议: 获取method uri以及请求参数
 * 
 * @author zzw
 *
 */

public class Request {
	//协议信息
	private String requestInfo;
	//请求方式
	private String method;
	//请求url
	private String url;
	//请求参数
	private String queryString;
	private final String CRLF="\r\n";
	public Request(Socket client) throws IOException{
		this(client.getInputStream()); //this只能在首行 ,必须throws
		
	}
	
	public Request(InputStream is) {
		byte[] datas=new byte[1024*1024];
		int len;
		try {
			len=is.read(datas);
			System.out.println("读取了\t"+len+"\t数据");
			this.requestInfo=new String(datas,0,len);
			System.out.println(requestInfo);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		//分解字符串
		parseRequestInfo();
	}
	
	private void parseRequestInfo() {
		System.out.println("------------解析RequestInfo-------------");
		System.out.println("----------1--获取请求方式 开头到第一个/------------");
		this.method=this.requestInfo.substring(0,this.requestInfo.indexOf("/")).toLowerCase().trim();
		System.out.println("this.method=:\t"+this.method);
		System.out.println("----------2--获取请求url ------------");
		System.out.println("---------可能包含请求参数?前面的为url ------------");
		//1 获取第一个 /
		int startIndex=this.requestInfo.indexOf("/")+1;
		//2 获取HTTP/的位置
		int endIndex=this.requestInfo.indexOf("HTTP/")-1;
		//3 分割字符串
		this.url=requestInfo.substring(startIndex,endIndex);
		System.out.println("this.url=:\t"+this.url);
		//4 获取问号的位置
		int queryIndex=this.url.indexOf("?");
		if (queryIndex>=0) {
			//存在请求参数
			String[] urlArray=this.url.split("\\?");
			this.url=urlArray[0];
			this.queryString=urlArray[1];
		}
			
		//5 获取url后面的请求参数
		System.out.println("----------3--获取url后面的请求参数 GET已经获取 Post可能在请求体中------------");
		if (method.equals("post")) {
			String qString=this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
			if (null==queryString) {
				queryString=qString;
			}else {
				queryString+="&"+qString;
			}
		}
		if (queryString==null) {
			queryString="";
		}
		System.out.println("this.queryString=:\t"+this.queryString);
		
		
		
	}


}
