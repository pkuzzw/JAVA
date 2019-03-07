package cn.zzw.basic;


/**
 * 懒汉式单例模式
 * 1  构造函数私有化
 * 2  加载时在初始化单例对象
 * 3  提供一个公有的方法接口来获取单例对象
 * @author zzw
 *
 */
public class SingletonDemo02 {
	private String name=null;
	private static SingletonDemo02 s;
	private SingletonDemo02() {
		System.out.println("懒汉式单例对象创建");
	}
	public static synchronized SingletonDemo02 getInstance() {
		if (s==null) {
			s=new SingletonDemo02();
		}
		return s;
	}
	
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}

}
