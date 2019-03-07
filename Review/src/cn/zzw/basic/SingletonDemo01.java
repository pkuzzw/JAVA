package cn.zzw.basic;

/**
 * 懒汉式单例模式
 * 1 构造函数私有化
 * 2 加载时初始化单例对象
 * 3 提供一个公有方法获取单例对象
 * @author zzw
 *
 */
public class SingletonDemo01 {
	private String name=null;
	private SingletonDemo01() {
		//私有化构造函数
		System.out.println("饿汉式单例对象创建");
	}
	private static SingletonDemo01 s=new SingletonDemo01();
	public  static SingletonDemo01 getInstance() {
		return s;
	}
	public String getName() {
		return name;
		
	}
	public void setName(String name) {
		this.name=name;
	}

}
