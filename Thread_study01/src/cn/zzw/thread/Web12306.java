package cn.zzw.thread;
/**
 * 共享资源  并发(线程安全)
 * 测试使用Runnable共享资源
 * @author zzw
 *
 */

public class Web12306 implements Runnable{
	//票数
	private int ticketNumbers=99;
	
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
		Web12306 web=new Web12306();
		System.out.println(Thread.currentThread().getName());
		new Thread(web,"1").start();
		new Thread(web,"2").start();
		new Thread(web,"3").start();
	}

}
