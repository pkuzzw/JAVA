package cn.zzw.others;

import java.util.TimerTask;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;


/**
 * 任务调度:借助Timer和TimerTask类
 * @author zzw
 *
 */

public class TimerTest01 {
	public static void main(String[] args) {
		Timer timer=new Timer();
		//执行安排
//		timer.schedule(new MyTask(), 1000*10);//执行任务一次
//		timer.schedule(new MyTask(), 1000, 2000);//执行多次
		
		Calendar calendar=new GregorianCalendar(2099, 12, 2);
		timer.schedule(new MyTask(),calendar.getTime(),	200);//指定时间
		
		
	}

	

}


//任务类 多线程
class MyTask extends TimerTask{

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println("放空大脑,休息一会");
		}
		System.out.println("End");
	}
	
}