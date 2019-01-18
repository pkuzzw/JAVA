package cn.zzw.thread_state;
/**
 * join() 合并线程 插队线程
 * 
 * @author zzw
 *
 */

public class BlockedJoin {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t=new Thread(()->{
			for (int i = 0; i < 100; i++) {
				System.out.println("lambda.........."+i);
			}
			
		});
		t.start();
		
		for (int i = 0; i < 100; i++) {
			if (i==20) {
				t.join();//插队  main主线程被阻塞 必须等到t执行完才可以执行其他线程
			}
			System.out.println("main....."+i);
			
		}
	}

}
