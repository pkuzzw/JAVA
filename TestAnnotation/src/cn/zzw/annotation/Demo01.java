package cn.zzw.annotation;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {
	
	
	@Override
	public String toString() {
		return "";
	}

	@Deprecated
	public static void test001() {
		List list=new ArrayList();
		System.out.println("test001");
	}
	
	@SuppressWarnings("all")
	public static void test002() {
		List list=new ArrayList();
		List list2=new ArrayList();
		System.out.println("test001");
	}
	
	
	public static void main(String[] args) {
		test001();
		
	}
}
