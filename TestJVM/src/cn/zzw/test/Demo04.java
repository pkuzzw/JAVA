package cn.zzw.test;
/**
 * 测试简单的加密解密(取反)
 * @author zzw
 *
 */

public class Demo04 {

	public static void main(String[] args) throws Exception {
//		int a=3;//0000 0011
//		System.out.println(Integer.toBinaryString(a^0xff));
		
		//测试取反后的文件  正常的加载文件无法加载
//		FileSystemClassLoader loader=new FileSystemClassLoader("/home/zzw/code1");
//			Class<?> c=loader.loadClass("helloworld");
//			System.out.println(c);
//			
//		
		//现在利用我们编写的DecryptClassLoader可以对加密后的class文件正常加载
		DecryptClassLoader loader=new DecryptClassLoader("/home/zzw/code1");
		Class<?> c=loader.loadClass("helloworld");
		System.out.println(c);
		
		
	}
}
