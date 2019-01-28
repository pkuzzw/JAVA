package cn.zzw.Singleton;
/**
 * 通过枚举实现单例模式
 * 
 * 优点: 实现简单
 * 		枚举本身就是单例模式,由JVM从根本上提供保障,避免通过反射和反序列化的漏洞
 * 
 * 缺点: 无法延迟加载
 * @author zzw
 *
 */

public enum SingletonDemo05 {
	//定义一个枚举的元素,它就代表了Singleton的一个实例
	INSTANCE;
	//单例可以有自己的操作
	public void singletonOperation() {
		System.out.println("SingletonDemo05 Enum Operation");
		
	}

}
