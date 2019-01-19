package cn.zzw.others;
/**
 * 用于保证数据的同步:也就是可见性
 * 
 * Volatile 保证数据的同步性,但是不保证原子性
 * 
 * @author zzw
 *
 */

public class VolatileTest {
	private volatile static int num=0;
	public static void main(String[] args) {
		new Thread(()->{
			while(num==0) {//此处不要编写代码
				
			}			
		}).start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		num=1;
		
	}

}
