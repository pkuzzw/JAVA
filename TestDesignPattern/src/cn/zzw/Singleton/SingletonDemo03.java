package cn.zzw.Singleton;
/**
 * 利用  双重检测锁式   实现单例模式
 * Double Check Lock
 * 这个模式将同步内容下放到if内部,提高了执行效率,不必每次获取对象时进行同步,只有第一次猜同步
 * 创建了以后就没必要同步了
 * @author zzw
 *
 */

public class SingletonDemo03 {
	private static SingletonDemo03 instance=null;
	private SingletonDemo03() {
		//私有化构造函数
		System.out.println("SingletonDemo03 constructor");
	}
	public static SingletonDemo03 getInstance() {
		if (instance==null) {
			SingletonDemo03 sc;
			synchronized (SingletonDemo03.class) {
				sc=instance;
				if (sc==null) {
					synchronized (SingletonDemo03.class) {
						if (sc==null) {
							sc=new SingletonDemo03();	
						}
					}
					instance=sc;
				}
			}
		}
		return instance;
		
		
	}
	

}
