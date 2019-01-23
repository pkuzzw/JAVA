package cn.zzw.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * Reflection:把Java类中的各种结构(方法/属性/构造器/类名)映射成一个个的JAVA对象
 * 1	获取CLASS对象
 * 		三种方式 
 * 			类.Class()
 * 			对象.getClass()
 * 			Class.forNmae("包名.类名")  完整路径
 * 2    解剖 
 * 		可以动态创建对象
 * 		(Iphone)clz.getConstructor().newInstance();
 * 
 * 
 * @author zzw
 *
 */

public class RflectionTest {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//三种方式获取Class对象
		//1 对象.getClass()
		Iphone iphone=new Iphone();
		Class clz=iphone.getClass();
		
		//2 类.class()
		clz=Iphone.class;
		
		//3 Class.forName("包名.类名")  完整路径
		clz=Class.forName("cn.zzw.server.basic.Iphone");
		
		
		//创建对象
		try {
			Iphone iphone2=(Iphone)clz.newInstance();
			System.out.println(iphone2);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		//jdk9推荐用构造器
		Iphone iphone3=(Iphone)clz.getConstructor().newInstance();
		System.out.println(iphone3);
		
		
		
	}

}
class Iphone{
	
	public Iphone() {
		// TODO Auto-generated constructor stub
	}
}
