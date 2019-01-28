package cn.zzw.Singleton;
/**
 * 饿汉式单例模式
 * 1 构造器私有化
 * 2 一个静态属性
 * 3 只有一个public 供外部使用
 * 
 * 注意:
 * 		由于加载类时,天然的线程安全,方法没有同步,效率高
 * @author zzw
 *
 */

public class SingletonDemo01 {
	//类初始化时立即加载 
	//由于加载类时,天然的线程安全,方法没有同步,效率高
	private static SingletonDemo01 instance=new SingletonDemo01();
	
	private SingletonDemo01() {
//		System.out.println("SigletonDemo01 Constructor");
	}
	public static SingletonDemo01 getInstance() {
		return instance;
	}

}
