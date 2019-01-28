package cn.zzw.Singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * 比较五种不同单例模式的效率
 * 
 * 多线程条件下测试
 * 
 * @author zzw
 *
 */

public class Test3 {
	public static void main(String[] args) throws Exception {
		long startTime=System.currentTimeMillis();
		int threadNumber=10;
		final CountDownLatch countDownLatch=new CountDownLatch(threadNumber);
		for (int i = 0; i < threadNumber; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					//调用相关的方法
					for (int i = 0; i < 1000000; i++) {
//						Object object=SingletonDemo04.getInstance();
						Object object=SingletonDemo05.INSTANCE;
					}
					countDownLatch.countDown();//每个线程执行完,计数器减一
				}
			}).start();
		}
		countDownLatch.await();//阻塞线程,直到其他所有线程执行完毕

		long endTime=System.currentTimeMillis();
		System.out.println("总耗时:\t"+(endTime-startTime));
		
		
		
		
		
		
		
		
	}

}
