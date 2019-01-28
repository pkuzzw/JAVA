package cn.zzw.Singleton;
/**
 * 懒汉式单例模式实现
 * 
 * 
 * 线程安全 调用效率不高  但是可以延时
 * @author zzw
 *
 */

public class SingletonDemo02 {
	//类初始化时,不初始化这个对象(延时加载,真正用的时候在创建)
	private static SingletonDemo02 instance;
	private SingletonDemo02() {
//		System.out.println("SingletonDemo02 constructor");
	}
	//方法同步 调用效率低
	public  static synchronized SingletonDemo02 getInstance() {
		if (null==instance) {
			instance=new SingletonDemo02();
		}
		return instance;
	}

}
