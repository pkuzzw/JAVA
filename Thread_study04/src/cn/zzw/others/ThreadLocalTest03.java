package cn.zzw.others;


/**
 * ThreadLocal  分析上下文 
 * 1 重点看它的起点 构造器 构造函数属于谁 找线程体
 * 2 run方法: 本线程自身的
 * get/set/initialValue
 * @author zzw
 *
 */

public class ThreadLocalTest03 {
	private static ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->1);
	public static void main(String[] args) {
		new Thread(new MyRun()).start();
		new Thread(new MyRun()).start();

	}
	public static class MyRun implements Runnable{
		
		public MyRun() {
			threadLocal.set(99);
			System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());

		}
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+"000-->"+threadLocal.get());
		}
	}
}
