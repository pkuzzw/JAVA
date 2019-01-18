package cn.zzw.synchronize;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作容器
 * 
 * @author zzw
 *
 */

public class SynBlockTest02 {
	public static void main(String[] args) throws InterruptedException {
		List<String> list=new ArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			new Thread(()->{
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
				}).start();
		}
		
		Thread.sleep(1000);
		System.out.println(list.size());
		
	}//main
	

}

