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
public class SynTest01 {
	public static void main(String[] args) {
		//一份资源
		SafeWeb12306 web=new SafeWeb12306();
		//多个代理
		new Thread(web,"A").start();
		new Thread(web,"B").start();
		new Thread(web,"C").start();

	}

}
class SafeWeb12306 implements Runnable{
	//票数
	private int ticketNumbers=1000;
	private boolean flag=true;
	
	@Override
	public void run() {
		while (flag) {
			try {
				// 模拟延时
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			test();
			
		}
		
	}
	//线程安全-->同步
	public synchronized void test() {
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
