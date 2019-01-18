package cn.zzw.thread_state;
/**
 * yield() 礼让线程,暂停线程,直接让线程进入就绪状态,重新等待调度
 * @author zzw
 *
 */


public class YieldDemo02 {
	public static void main(String[] args) {
		new Thread(()-> {
			for (int i = 0; i < 100	; i++) {
				System.out.println("lambda...."+i);
			}
		}).start();
		
		for (int i = 0; i < 100; i++) {
			if (i%20==0) {
				Thread.yield();
			}
			System.out.println("main......"+i);
		}

	}

}

