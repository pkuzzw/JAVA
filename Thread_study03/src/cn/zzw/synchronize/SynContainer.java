package cn.zzw.synchronize;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;//在写的基础上进行拷贝
import java.util.List;

/**
 * 线程安全: 操作并发容器
 * 
 * @author zzw
 *
 */

public class SynContainer {
	public static void main(String[] args) throws InterruptedException {
		CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			new Thread(()->{
					list.add(Thread.currentThread().getName());
				}).start();
		}
		
		Thread.sleep(1000);
		System.out.println(list.size());
		
	}//main
	

}

