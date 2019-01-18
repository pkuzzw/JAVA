package cn.zzw.synchronize;
/**
 * 线程不安全,数据由重复的地方,以及数据有负数的地方
 * 
 * @author zzw
 *
 */
public class UnsafeTest01 {
	public static void main(String[] args) {
		//一份资源
		UnSafeWeb12306 web=new UnSafeWeb12306();
		//多个代理
		new Thread(web,"A").start();
		new Thread(web,"B").start();
		new Thread(web,"C").start();

	}

}
class UnSafeWeb12306 implements Runnable{
	//票数
	private int ticketNumbers=10;
	private boolean flag=true;
	
	@Override
	public void run() {
		while (flag) {
			test();
			
		}
		
	}
	public void test() {
		if (ticketNumbers<0) {
			System.out.println("没票了");
			flag=false;
			return;
		}
//		try {
//			//模拟延时
//			Thread.sleep(200);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println(Thread.currentThread().getName()+"\t剩余票数:\t\t"+(ticketNumbers--));
		
	}
	
	
	
}
