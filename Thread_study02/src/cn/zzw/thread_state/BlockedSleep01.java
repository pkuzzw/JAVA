package cn.zzw.thread_state;
/**
 * 使用sleep模拟网络延迟,放大了问题发生的可能性
 * 
 * @author zzw
 *
 */

public class BlockedSleep01  implements Runnable{

	private int ticketNumbers=99;
	
	
	/**
	 * 共享资源,并发(线程安全)
	 */
	@Override
	public void run() {
		while (true) {
			if (ticketNumbers<0) {
				System.out.println("没票了");
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"剩余票数:\t"+(ticketNumbers--));
		}
	}
	
	
	public static void main(String[] args) {
		//一份资源,多个代理
		BlockedSleep01 bs=new BlockedSleep01();
		System.out.println(Thread.currentThread().getName());
		new Thread(bs,"1").start();
		new Thread(bs,"2").start();
		new Thread(bs,"3").start();
	}
}
