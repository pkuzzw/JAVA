package cn.zzw.thread_state;

import java.lang.Thread.State;


/**
 * 观察线程所有的状态
 * 
 * @author zzw
 *
 */
public class AllState {
	public static void main(String[] args) {
		Thread t=new Thread(()->{
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("lambda.......");

			}
			
		});
		//观察状态println
		State state=t.getState();
		System.out.println(state.toString());//NEW
		
		
		t.start();
		state=t.getState();
		System.out.println(state.toString());//RUNNABLE
		while(state!=Thread.State.TERMINATED) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			state=t.getState();//TIMED-WAITING
			System.out.println(state.toString());//
			System.out.println(Thread.activeCount());
		}
		


		
		
		
		
	}

}
