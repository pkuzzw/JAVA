package cn.zzw.thread_state;
/**
 * 优先级测试
 * 线程的优先级  从0到10
 * NORM_PRIORITY=5 //所有线程默认都是5
 * MAX_PRIORITY=10
 * MIN_PRIORITY=1  
 * 
 * 设置线程优先级和读取优先级利用如下方法
 * int getPriority();
 * void setPriority(int newPriority)
 * 
 * 
 * 优先级只是代表概率,并不一定先执行
 * @author zzw
 *
 */

public class PriorityTest {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getPriority());
		MyPriority mp= new MyPriority();
		Thread t1=new Thread(mp,"Nike");
		Thread t2=new Thread(mp,"Adidas");
		Thread t8=new Thread(mp,"Anta");
		Thread t3=new Thread(mp,"DoubleStars");
		Thread t4=new Thread(mp,"LiNing");
		Thread t5=new Thread(mp,"SevenWolf");
		Thread t6=new Thread(mp,"Adidid");
		Thread t7=new Thread(mp,"Jordan");

		//设置优先级在start()之前
		t1.setPriority(2);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		

	}

}
class MyPriority implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
		Thread.yield();
	}
}
