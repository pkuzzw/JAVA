package cn.zzw.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 打印流 PrintStream
 * @author zzw
 *
 */

public class PrintTest {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps=System.out;
		ps.println("打印流");
		ps.println(true);
		
		ps=new PrintStream(new BufferedOutputStream(new FileOutputStream("p.txt")),true);
		ps.append("hello,world");
//		ps.flush();
		ps.close();
		
		//重定向输出端
		System.setOut(ps);
		System.out.println("\nchange\n");
		System.out.append("c");
		
		//重定向回控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("change\n");

		
		
	}

}
