package cn.zzw.thread_state;
/**
 * yield() 礼让线程,暂停线程,直接让线程进入就绪状态,重新等待调度
 * @author zzw
 *
 */


public class YieldDemo01 {
	public static void main(String[] args) {
		MyYield my=new MyYield();
		
		new Thread(my,"a").start();
		new Thread(my,"b").start();

	}

}


class MyYield implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--->start");
		Thread.yield();//礼让
		System.out.println(Thread.currentThread().getName()+"--->end");

		
	}
	
}