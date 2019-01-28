package cn.zzw.Singleton;

public class Test {
	public static void main(String[] args) {
		System.out.println("--------SingletonDemo01 Test--------");
		SingletonDemo01 s1=SingletonDemo01.getInstance();
		SingletonDemo01 s2=SingletonDemo01.getInstance();
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s1==s2);
		
		System.out.println("--------SingletonDemo02  Test--------");
		SingletonDemo02 s3=null;
		s3=SingletonDemo02.getInstance();
		System.out.println("--------SingletonDemo03  Test--------");
		SingletonDemo03 s4=null;
		s4=SingletonDemo03.getInstance();
		System.out.println("--------SingletonDemo04  Test--------");
		SingletonDemo04 s5=null;
		System.out.println("--------SingletonDemo04  Test--------");
		s5=SingletonDemo04.getInstance();
		System.out.println("--------SingletonDemo05  Test--------");
		
		
		
	}

}
