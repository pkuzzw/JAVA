package cn.zzw.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 目标:返回响应协议
 * @author zzw
 *
 */

public class Server02 {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		Server02 server=new Server02();
		server.start();
		
	}
	
	//启动服务
	public void start() {
		try {
			serverSocket=new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
		}
	}

	
	//停止服务
	public void receive() {
		try {
			//一个client就代表一个浏览器
			Socket client=serverSocket.accept();
			System.out.println("一个客户端建立了连接");
			
			
			//获取请求协议
			InputStream is=client.getInputStream();
			byte[] datas=new byte[1024*1024];
			int len=is.read(datas);
			System.out.println("读取了\t"+len+"\t数据");
			String requestInfo=new String(datas,0,len);
			System.out.println(requestInfo);
			StringBuilder content=new StringBuilder();
			content.append("<html>");
			content.append("<head>");
			content.append("<title>");
			content.append("服务器响应成功");
			content.append("</title>");
			content.append("</head>");
			content.append("<body>");
			content.append(".......终于回来了......");
			content.append("</body>");
			content.append("</html>");
			
			int content_length=content.toString().getBytes().length;//一定要获得字节长度
			StringBuilder responseInfo=new StringBuilder();
			String blank="";
			String CRLF="\r\n";
			//进行响应,返回响应协议
			//1 响应行:HTTP/1.1 200 OK
			responseInfo.append("HTTP/1.1").append(blank);
			responseInfo.append(200).append(blank);
			responseInfo.append("OK").append(CRLF);
			//2 响应头:(最后一行是空行)
			 /*Date:Mon,31Dec209904:25:57GMT
			 *Server:zzw_Server/0.0.1;charset=GBK
			 *Content-type:text/html
			 *Content-length:39725426
			 *
			 */
			
			responseInfo.append("Date:").append(new Date()).append(CRLF);
			responseInfo.append("Server:").append("zzw_Server/0.0.1;charset=GBK").append(CRLF);
			responseInfo.append("Content-type:text/html").append(CRLF);
			responseInfo.append("Content-length:").append(content_length).append(CRLF);
			responseInfo.append(CRLF);
			//3 请求正文
			responseInfo.append(content.toString());
	
			//写出到客户端 做出响应
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(responseInfo.toString());
			bw.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
		
	}
	
	
	
	//接收连接处理
	public void stop() {

		
		
	}
	

}
