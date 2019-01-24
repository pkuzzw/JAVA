package cn.zzw.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import cn.zzw.javabean.User;
/**
 * 通过反射API 动态的操作:构造器 方法 属性
 * @author zzw
 *
 */
@SuppressWarnings("all")
public class Demo03 {
	public static void main(String[] args) {
		String path="cn.zzw.javabean.User";
		
		try {
			//获取类的信息
			Class clz=Class.forName(path);
			//获取构造器
			Constructor c=clz.getDeclaredConstructor(int.class,int.class,String.class);
			
			
			//通过反射API  newInstance() 动态调用构造方法:构造对象
			User u=(User) clz.newInstance(); //其实是调用了User的无参构造方法
			u=(User) clz.getDeclaredConstructor(int.class,int.class,String.class).newInstance(1,2,"三");
			System.out.println(u);
			
			
			//通过反射API调用普通方法
			User u1=(User)clz.newInstance();
			Method method=clz.getDeclaredMethod("setName", String.class);
			System.out.println(method);
			method.invoke(u1, "zzw");
			System.out.println(u1);
			
			
			//通过反射API操作属性
			Field f=clz.getDeclaredField("name");
			f.setAccessible(true);
			f.set(u1, "zhou");
			f=clz.getDeclaredField("id");
			f.setAccessible(true);
			f.set(u1, 111);
			f=clz.getDeclaredField("age");
			f.setAccessible(true);
			f.set(u1, 18);
			System.out.println(u1);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
