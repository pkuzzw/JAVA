package cn.zzw.Singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

//import java.lang.reflect.Constructor;

/**
 * 测试反射和反序列化破解
 * @author zzw
 *
 */
public class Test2 {
	public static void main(String[] args) throws Exception {
		System.out.println("--------SingletonDemo06 Test--------");
		SingletonDemo06 s1=SingletonDemo06.getInstance();
		SingletonDemo06 s2=SingletonDemo06.getInstance();
		
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1==s2);
		
		
		//通过反射的方式,直接调用私有构造方法
//		Class<SingletonDemo06> clz=(Class<SingletonDemo06>) Class.forName("cn.zzw.Singleton.SingletonDemo06");
		
		
		//获得构造器
//		Constructor<SingletonDemo06> constructor=clz.getDeclaredConstructor(null);
//		//关键在这一步,跳过安全检查
//		constructor.setAccessible(true);
//		SingletonDemo06 s3=constructor.newInstance();
//		constructor.setAccessible(true);
//		SingletonDemo06 s4=constructor.newInstance();
//		
//		System.out.println(s3);
//		System.out.println(s4);
		
		
		//通过反序列化的方式构造多个对象
		//序列化存储到指定文件
		FileOutputStream fos=new FileOutputStream(new File("/home/zzw/code/a.txt"));
		ObjectOutputStream os=new ObjectOutputStream(fos);
		os.writeObject(s1);
		
		os.close();
		fos.close();
		//反序列化
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("/home/zzw/code/a.txt")));
		SingletonDemo06 s3=(SingletonDemo06)ois.readObject();
		System.out.println(s3);
	}

}
