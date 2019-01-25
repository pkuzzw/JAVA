package cn.zzw.testjavassist;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * 测试Javassist的API
 * @author zzw
 *
 */

public class Demo02 {
	
	/**
	 * 处理类的基本用法
	 * @throws Exception 
	 */
	public static void test01() throws Exception {
		//获得已有的类
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.get("cn.zzw.testjavassist.Emp");
		
		byte[] bytes=cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		
		System.out.println("cc.getName():\t)"+cc.getName());
		System.out.println("cc.getSimpleName():\t"+cc.getSimpleName());
		System.out.println("cc.getSuperclass():"+cc.getSuperclass());
		System.out.println("cc.getInterfaces():"+cc.getInterfaces());
		
	}
	/**
	 * 测试产生的方法
	 * @throws Exception 
	 */
	public static void test02() throws Exception {
		//获得已有的类
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.get("cn.zzw.testjavassist.Emp");
		
//		CtMethod m=CtMethod.make("public int add(int a,int b){return a+b;}", cc);
	
		CtMethod m=new CtMethod(CtClass.intType, "add", new CtClass[] {CtClass.intType,CtClass.intType},cc);
		//设置访问权限
		m.setModifiers(Modifier.PUBLIC);
		//添加方法体  带大括号
		m.setBody("{System.out.println(\"hello,world\"); return $1+$2;}");
		
		//添加到类中
		cc.addMethod(m);
		
		//通过反射调用新生成的方法
		Class clazz=cc.toClass();
		Object obj=clazz.newInstance();  //通过调用无惨构造器 创建新的Emp对象
		//获得方法
		Method method=clazz.getDeclaredMethod("add", int.class,int.class);
		Object result=method.invoke(obj, 200,300);
		System.out.println(result);
		
		
		
		
		//new CtMethod(returnType, mname, parameters, declaring)
	}
	
	public static void main(String[] args) throws Exception {
//		test01();
		test02();
		
	}

}
