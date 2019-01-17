package cn.zzw.thread;
/**
 * 创建线程方式二 实现Runnable接口
 * 1 创建:实现Runnable
 * 2 重写run()方法
 * 3 创建实现类对象+Thread对象才能调用start()
 * 
 * 
 * 推荐:避免单继承的局限性,优先使用接口
 * Lambda表达式 简化线程的使用(用一次或者很少的使用)
 * 
 * @author zzw
 *
 */

public class LambdaThread{
	//静态内部类
	static class Test implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("一边听歌");
		}
	 }
	}
	
	public static void main(String[] args) {
		
		new Thread(new Test()).start();
		
		//局部内部类
		class Test2 implements Runnable{
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println("我在一边听歌");
				}
			 }
			}
		
		new Thread(new Test2()).start();
		
		
		//匿名内部类  必须借助接口或者父类
		
		//没有实现类的名称,带上类体
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 20; i++) {
					System.out.println("我是匿名内部类");
				}
			}
		}).start();

		
		//jdk8 Lambda
		//用于简化线程的实现
		new Thread(()->{
			for (int i = 0; i < 20; i++) {
				System.out.println("我是Lambda");
			}
			}).start();
		
	
	}
}
