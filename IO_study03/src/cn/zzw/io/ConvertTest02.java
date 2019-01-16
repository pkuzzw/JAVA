package cn.zzw.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 转换流 InputStreamReader / OutputStreamWriter
 * 1 以字符流的形式处理字节流 (纯文本的)
 * 2 指定字符集
 * @author zzw
 *
 */

public class ConvertTest02 {
	//操作一个网络流  下载百度的源代码
	
	public static void main(String[] args) {
		try(BufferedReader reader=
				new BufferedReader(
						new InputStreamReader(new URL("http://www.163.com").openStream(),"GBK"));
				BufferedWriter writer=
						new BufferedWriter(
								new OutputStreamWriter(new FileOutputStream("baidu.html"),"UTF-8"))){
			String msg="";
			while ((msg=reader.readLine())!=null) {
				writer.write(msg);
				writer.newLine();
				writer.flush();
				
			}
			
			
		
		}catch (IOException e) {
			System.out.println("操作异常");
		}
	}//main
	public static void test02() {
		try(InputStreamReader is=new InputStreamReader(new URL("http://www.163.com").openStream(),"GBK");){
			int len=-1;
			while((len=is.read())!=-1) {
				//已经读取到len个数据到buffer
				System.out.print((char)len);
			}
			
			
		
		}catch (IOException e) {
			System.out.println("操作异常");
		}
	}
	

}
