package cn.zzw.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 运用反射API获取类的信息(类的名字/属性/方法/构造器)
 * @author zzw
 *
 */
@SuppressWarnings("all")
public class Demo02 {
	public static void main(String[] args) {
		String path="cn.zzw.javabean.User";
		
		try {
			//获取类的信息
			Class clz=Class.forName(path);
			
			//获取类的名字
			System.out.println("类的名字:\t"+clz.getName());//获得包名+类名
			System.out.println("类的名字:\t"+clz.getSimpleName());//获取类名
			
			System.out.println("-----------------------");
			//获取类的属性
			Field[] fields=clz.getFields();
			for (Field field : fields) {
				System.out.println(field);
			}
			System.out.println("-----------------------");
			fields=clz.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field);
			}
			System.out.println("-----------------------");
			Field field=clz.getDeclaredField("name");
			System.out.println(field.getName());
			
			//获取方法信息
			System.out.println("--------Public-Method--------------");
			Method[] method=clz.getMethods();
			for (Method method2 : method) {
				System.out.println(method2);
			}
			System.out.println("--------All--Method--------------");
			method=clz.getDeclaredMethods();
			for (Method method2 : method) {
				System.out.println(method2);
			}
			Method method1=clz.getDeclaredMethod("setName", String.class);
			System.out.println(method1);
			
			System.out.println("-----------get Constructors----------");
			//获取构造器
			Constructor[] constructors=clz.getConstructors();
			for (Constructor constructor : constructors) {
				System.out.println(constructor);
			}
			System.out.println("-----------get Declared Constructors----------");
			constructors=clz.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				System.out.println(constructor);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
