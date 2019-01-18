package cn.zzw.thread_state;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * sleep()模拟倒计时
 * @author zzw
 *
 */

public class BlockSleep03 {
	public static void main(String[] args) throws InterruptedException {
		//倒数十个数,一秒一个
		
		Date endTime=new Date(System.currentTimeMillis()+1000*10);
		long end=endTime.getTime();
		while (true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			Thread.sleep(1000);
			endTime=new Date(endTime.getTime()-1000);
			if (end-10000>endTime.getTime()) {
				break;
			}
		}
	}
	
	public static void test() throws InterruptedException {
		//倒数十个数,一秒一个
		int num=10;
		while (true) {
//			if (num<0) {
//				break;
//			}
			Thread.sleep(1000);
			System.out.println(num--);
		}
	}

}
