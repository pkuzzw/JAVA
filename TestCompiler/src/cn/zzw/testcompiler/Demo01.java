package cn.zzw.testcompiler;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;


/**
 * 测试动态编译 JavaCompiler
 * 
 * 1 获取JavaCompiler
 * @author zzw
 *
 */
@SuppressWarnings("all")
public class Demo01 {
	public static void main(String[] args) {
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		int result=compiler.run(null, null, null, "/home/zzw/eclipse-workspace/testJavaCompiler/hello.java");
		System.out.println(result==0?"编译成功":"编译失败");

		System.out.println("开始编译String了---------------");
		String string="public class hello{\n" + 
				"	public static void main(String[] args){\n" + 
				"		System.out.println(\"hello,World\");\n" + 
				"	}\n" + 
				"}";
		String path="hello.java";
		stringToFile(string,path );
		result=compiler.run(null, null, null, path);
		System.out.println(result==0?"编译成功":"编译失败");
		
		//运行方法一
//		通过Runtime来动态运行程序
//		Runtime runtime=Runtime.getRuntime();
//		try {
//			System.out.println("开始运行");
//			Process process=runtime.exec("java -cp /home/zzw/eclipse-workspace/TestCompiler/  hello");
//			InputStream is=process.getInputStream();
//			BufferedReader br=new BufferedReader(new InputStreamReader(is));
//			String infoString=" ";
//			while ((infoString=br.readLine())!=null) {
//				System.out.println(infoString);
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		//获得运行的输出
		
		
		
		
		//运行方法二 通过反射API来运行
		
		try {
			String dir="/home/zzw/eclipse-workspace/testJavaCompiler";
			URL[] urls=new URL[] { new URL("file:/"+dir)};
			URLClassLoader loader=new URLClassLoader(urls);
			Class c=loader.loadClass("hello");
			//调用加载类的main方法
			c.getMethod("main", String[].class).invoke(null,(Object) new String[] {});
			//由于可变参数是JDK5.0以后才有,上面代码会编译成:m.invoke(null,"aa","bb"),这样就发生了参数个数不匹配的问题
			//因此,必须加上(Object)转型,避免这个问题
			
			//如果是public static void mmm(String[] a,String[] b)
			//则对应的invoke(null,(Object) new String[]{} ,(Object) new String[]{} )
			//注意String[]{}后面要有大括号,传递的参数放在里面
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	//将字符串转存成一个java文件
	public static void stringToFile(String string,String path) {
		File file=new File(path);
		FileWriter os = null;
		try {
			os = new FileWriter(file);
			os.write(string);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		try {
			if (null!=os) {
				os.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
