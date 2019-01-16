package cn.zzw.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流 InputStreamReader / OutputStreamWriter
 * 1 以字符流的形式处理字节流 (纯文本的)
 * 2 指定字符集
 * @author zzw
 *
 */

public class ConvertTest {

	public static void main(String[] args) {
		//操作System.in 和System.out
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(System.out));){
			//循环获取键盘的输入,输出此内容
			String msg="";
			while(!msg.equals("exit")) {
				msg=reader.readLine();//循环读取
				writer.write(msg);
				writer.newLine(); //循环写出
				writer.flush();
			}
		}catch (IOException e) {
			System.out.println("操作异常");
		}
		
		
		

	}

}
