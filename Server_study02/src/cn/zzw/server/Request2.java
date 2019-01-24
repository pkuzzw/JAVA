package cn.zzw.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装请求协议: 封装请求参数为Map
 * 
 * 处理中文 利用java.net.URLdecoder
 * 
 * @author zzw
 *
 */

public class Request2 {
	//协议信息
	private String requestInfo;
	//请求方式
	private String method;
	//请求url
	private String url;
	//请求参数
	private String queryString;
	//存储参数
	private Map<String, List<String>> parameterMap;
	
	private final String CRLF="\r\n";
	public Request2(Socket client) throws IOException{
		this(client.getInputStream()); //this只能在首行 ,必须throws
		
	}
	
	public Request2(InputStream is) {
		parameterMap=new HashMap<String,List<String>>();
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
		
		//转成Map  fav=18&fav=2&unma=zzw&age=18&others=
		
		convertMap();
	}
	
	//处理请求参数为Map
	public void convertMap() {
		System.out.println("...............convertMap.........");
		
		//1 分割字符串
		String[] keyValues=this.queryString.split("&");
		for (String string : keyValues) {
			//再次分割字符串 按照"="来分
			String[] kv=string.split("=");
			kv=Arrays.copyOf(kv, 2);
			//分别获取key和Value
			String key=kv[0];
			String value=kv[1]==null?null:decode(kv[1],"UTF-8");
			if (!parameterMap.containsKey(key)) {//第一次添加key,初始化value数组
				parameterMap.put(key, new ArrayList<String>());
			}
			parameterMap.get(key).add(value);
		}
	}
	/**
	 * 处理中文
	 * @param value
	 * @return
	 */
	private String decode(String value,String charset) {
		try {
			return java.net.URLDecoder.decode(value, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	/**
	 * 通过name获取对应的多个值
	 * @param key
	 * @return
	 */
	public String[] getParameterValues(String key) {
		List<String> values=this.parameterMap.get(key);
		if (null==values || values.size()<1) {
			return null;
		}
		
		return values.toArray(new String[0]);
	}
	
	public String getMethod() {
		return method;
	}


	public String getUrl() {
		return url;
	}


	public String getQueryString() {
		return queryString;
	}


	/**
	 * 通过name获取对应的一个值
	 * @param key
	 * @return
	 */
	public String getParameter(String key) {
		String[] values=getParameterValues(key);
		return values==null?null:values[0];
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
