package cn.zzw.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 打印流 PrintWriter
 * @author zzw
 *
 */

public class PrintTest02 {
	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter pw=new PrintWriter(new BufferedOutputStream(new FileOutputStream("p.txt")),true);
		pw.println("change to PrintWriter");
		pw.println(true);
		pw.close();
		
		
		
	}

}
