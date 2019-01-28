package cn.zzw.Singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 
 * 如何防止反射和反序列化漏洞
 * 
 *   懒汉式单例模式实现
 * 
 * 
 * 线程安全 调用效率不高  但是可以延时
 * @author zzw
 *
 */

public class SingletonDemo06 implements Serializable{
	//类初始化时,不初始化这个对象(延时加载,真正用的时候在创建)
	private static SingletonDemo06 instance;
	private SingletonDemo06() {
		System.out.println("SingletonDemo02 constructor");
		if (instance!=null) {
			throw new RuntimeException();
		}
	}
	//方法同步 调用效率低
	public  static synchronized SingletonDemo06 getInstance() {
		if (null==instance) {
			instance=new SingletonDemo06();
		}
		return instance;
	}
	
	//反序列化时,如果定义了ReadResolve方法,则直接返回此方法指定的对象,而不需要单独创建新的对象
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}

}
