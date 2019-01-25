package cn.zzw.testjavassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * 1	用Javassist创建一个类
 * 2	然后用XJAD反编译为一个JAVA文件
 * @author zzw
 *
 */
public class Demo01 {
	public static void main(String[] args) throws CannotCompileException, Exception {
		//创建类池
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.makeClass("cn.zzw.bean.Emp");
		System.out.println("创建类池完毕");
		//创建属性
		CtField f1=CtField.make("private int age;", cc);
		CtField f2=CtField.make("private String name;", cc);
		cc.addField(f1);
		cc.addField(f2);
		System.out.println("创建属性完毕");
		
		
		//创建方法
		CtMethod m1=CtMethod.make("public String getName(){return name;}", cc);
		CtMethod m2=CtMethod.make("public void SetName(String name){this.name=name;}", cc);
		CtMethod m3=CtMethod.make("public int getAge(){return age;}", cc);
		CtMethod m4=CtMethod.make("public void SetAge(int age){this.age=age;}", cc);
		cc.addMethod(m1);		
		cc.addMethod(m2);		
		cc.addMethod(m3);		
		cc.addMethod(m4);		
		System.out.println("创建方法完毕");
		
		
		//添加构造器
		CtConstructor constructor=new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")}, cc);
		System.out.println("--------------1----------------");
		constructor.setBody("{this.age=age;this.name=name;}");
		
		System.out.println("创建构造器完毕");
		cc.addConstructor(constructor);
		
		cc.writeFile("/home/zzw/eclipse-workspace/TestJavassist/src/myjava");
		System.out.println("生成类,成功");
		
		
		
		
	}

}
