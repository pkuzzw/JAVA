package cn.zzw.synchronize;
/**
 * 线程安全:在并发时保证数据的正确性 效率尽可能高
 * synchronized
 * 同步方法
 * 同步块
 * 
 * @author zzw
 *
 */
public class SynBlockTest03 {
	public static void main(String[] args) {
		//一份资源
		SynWeb12306 web=new SynWeb12306();
		//多个代理
		new Thread(web,"A").start();
		new Thread(web,"B").start();
		new Thread(web,"C").start();

	}

}
class SynWeb12306 implements Runnable{
	//票数
	private int ticketNumbers=20;
	private boolean flag=true;
	
	@Override
	public void run() {
		while (flag) {
//			try {
//				// 模拟延时
//				Thread.sleep(50);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			test5();
		}
	}
	
	//线程安全 尽可能锁定合理的范围(不是指代码,而是指数据的完整性)
	//Doubkle-Checking  考虑临界值的情形
	public synchronized void test5() {
		if (ticketNumbers<0) {//考虑的是没有票的情形
			System.out.println("没票了");
			flag=false;
			return;
		}
		synchronized (this) {
		if (ticketNumbers<0) {//考虑的是最后的一张票
			System.out.println("没票了");
			flag=false;
			return;
		}
		}
		try {
			//模拟延时
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"\t剩余票数:\t\t"+(ticketNumbers--));
		
	}
	
	
	//线程不安全 范围太小,锁不住
	public synchronized void test4() {
		synchronized (this) {
		if (ticketNumbers<0) {
			System.out.println("没票了");
			flag=false;
			return;
		}
		}
		try {
			//模拟延时
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"\t剩余票数:\t\t"+(ticketNumbers--));
		
	}
	
	
	
	
	//线程不安全 锁定失败
	public synchronized void test3() {
		synchronized ((Integer)ticketNumbers) {
		if (ticketNumbers<0) {
			System.out.println("没票了");
			flag=false;
			return;
		}
		try {
			//模拟延时
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"\t剩余票数:\t\t"+(ticketNumbers--));
		}
	}
	
	//同步块  范围太大 性能效率低下
	public synchronized void test2() {
		synchronized (this) {
		if (ticketNumbers<0) {
			System.out.println("没票了");
			flag=false;
			return;
		}
		try {
			//模拟延时
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"\t剩余票数:\t\t"+(ticketNumbers--));
		}
	}
	
	
	
	//线程安全-->同步
	public synchronized void test1() {
		if (ticketNumbers<0) {
			System.out.println("没票了");
			flag=false;
			return;
		}
		try {
			//模拟延时
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"\t剩余票数:\t\t"+(ticketNumbers--));
	}
	
	
	
}
