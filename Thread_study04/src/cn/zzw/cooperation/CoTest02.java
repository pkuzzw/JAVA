package cn.zzw.cooperation;
/**
 * 协作模型: 生产者 消费者
 * 实现方式一 信号灯法
 * 借助标志位
 * 
 * @author zzw
 *
 */

public class CoTest02 {
	
	public static void main(String[] args) {
		
		TV tv=new TV();
		new Player(tv).start();
		new Watcher(tv).start();
		
	}

}

//生产者 演员
class Player extends Thread{
	TV tv;
	public Player(TV tv) {
		super();
		this.tv = tv;
	}
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i%2==0) {
				this.tv.play("奇葩说");
			}else {
				this.tv.play("今日说法");
			}
		}
	}
}
//消费者 观众
class Watcher extends Thread{
	TV tv;
	public Watcher(TV tv) {
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			tv.wath();
		}
	}
}
//同一个资源 电视

class TV{
	String voice;
	
	//加入信号灯
	//True 表示演员表演,观众等待
	//False 表示观众观看,演员等待
	boolean flag=true;
	//表演
	public synchronized void play(String voice) {
		//演员等待
		if (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//表演时刻
		System.out.println("表演了:\t"+voice);
		this.voice = voice;
		//唤醒
		this.notifyAll();
		//切换标志
		this.flag=!this.flag;
		
		
	}
	//观看
	public synchronized void wath() {
		//观众等待
		if (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//观看
		System.out.println("听到了:\t"+voice);
		//唤醒
		this.notifyAll();
		//切换标志
		this.flag=!this.flag;
	}
}





























