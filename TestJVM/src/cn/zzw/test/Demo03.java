package cn.zzw.test;
/**
 * 测试自定义的FileSystemClassLoader
 * @author zzw
 *
 */

public class Demo03 {
	public static void main(String[] args) {
		FileSystemClassLoader loader=new FileSystemClassLoader("/home/zzw/code");
		FileSystemClassLoader loader2=new FileSystemClassLoader("/home/zzw/code");
		
		try {
			Class<?> c=loader.loadClass("helloworld");
			Class<?> c1=loader.loadClass("helloworld");
			Class<?> c2=loader2.loadClass("helloworld");
			Class<?> c3=loader2.loadClass("java.lang.String");
//			Class<?> c4=loader2.loadClass("/home/zzw/eclipse-workspace/TestJVM/src/cn/zzw/test/Demo02");
			System.out.println(c);
			System.out.println(c.hashCode());
			System.out.println(c1.hashCode());
			System.out.println(c2.hashCode());
			System.out.println(c1.getClassLoader());//自定义加载器
			System.out.println(c3.getClassLoader());  //引导类加载器
//			System.out.println(c4.getClassLoader());  //
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
