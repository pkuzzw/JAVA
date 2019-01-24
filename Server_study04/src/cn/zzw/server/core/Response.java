package cn.zzw.server.core;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;


public class Response {
	private BufferedWriter bw;
	//正文
	private StringBuilder content;
	//协议头信息 (包含状态行和请求头  回车)
	private StringBuilder headInfo;
	private int length;//正文的字节数

	private final String BLANK=" ";
	private final String CRLF="\r\n";
	private Response() {
		content=new StringBuilder();
		headInfo=new StringBuilder();
		length=0;
		
	}
	public  Response(Socket client) {
		this();
		try {
			bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			headInfo=null;
		}
		
	}
	public Response(OutputStream os) {
		this();
		bw=new BufferedWriter(new OutputStreamWriter(os));
	}
	//动态添加内容  流模式
	public Response print(String info) {
		content.append(info);
		length+=info.getBytes().length;
		return this;
	}
	
	//动态添加内容  流模式
	public Response println(String info) {
		content.append(info).append(CRLF);
		length+=(info+CRLF).getBytes().length;
		return this;
	}
	//推送响应信息
	public void pushToBrowser(int code) throws IOException {
		if (null==headInfo) {
			code=505;
		}
		createHeadInfo(code);
		bw.append(headInfo);
		bw.append(content);
		bw.flush();

	}
	//构建头信息
	private void createHeadInfo(int code) {
		//1 响应行:HTTP/1.1 200 OK
		headInfo.append("HTTP/1.1").append(BLANK);
		headInfo.append(code).append(BLANK);
		switch (code) {
		case 200:
			headInfo.append("OK").append(CRLF);
			break;
		case 404:
			System.out.println("404了啊兄弟");
			headInfo.append("NOT FOUND").append(CRLF);
			break;
		case 505:
			headInfo.append("SERVER ERROR").append(CRLF);
			break;
		}
		
		//2 响应头:(最后一行是空行)
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Server:").append("zzw_Server/0.0.1;charset=GBK").append(CRLF);
		headInfo.append("Content-type:text/html").append(CRLF);
		headInfo.append("Content-length:").append(length).append(CRLF);
		headInfo.append(CRLF);
		System.out.println("------给你看看headInfo--------");
		System.out.println(headInfo);
		
		System.out.println("------给你看看headInfo--------");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
