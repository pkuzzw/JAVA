package cn.zzw.basic;

public class B extends A {
	public int func(int a, int b) {
		return 0;
		
	}
//	public short func(int a, int b) {
//		return a+b+a;
//	}
	public static void main(String[] args) {
		A a=new A();
		B b=new B();
		
		System.out.println(a.func(1, 2));
		System.out.println(b.func(1, 2));
		
	}

}
