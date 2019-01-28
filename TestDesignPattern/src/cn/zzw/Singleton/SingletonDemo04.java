package cn.zzw.Singleton;
/**
 * 利用  静态内部类实现 单例模式
 * 
 * 线程安全 
 * 调用效率高
 * 并且实现延时加载
 * @author zzw
 *
 */
public class SingletonDemo04 {
	//静态内部类 实现单例模式
	private static class SingletonClassInstance{
		private static final SingletonDemo04 instance=new SingletonDemo04();
	}
	
	//构造函数私有化
	private SingletonDemo04() {
		//构造函数
		System.out.println("SingletonDemo04 Constructor");
	}
	
	
	public static SingletonDemo04 getInstance() {
		return SingletonClassInstance.instance;
	}

}
