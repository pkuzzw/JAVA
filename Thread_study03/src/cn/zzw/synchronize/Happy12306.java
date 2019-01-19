package cn.zzw.synchronize;
/**
 * 快乐火车票
 * 
 * 使用同步方法实现购票功能
 * @author zzw
 *
 */

public class Happy12306 {
	public static void main(String[] args) {
		Web12306 w=new Web12306(4, "动车");
		new Passenger(w, "A", 2).start();
		new Passenger(w, "B", 1).start();
		
		
	}

}
//顾客
class Passenger extends Thread{
	int seats;
	public Passenger(Runnable target,String name,int seats) {
		super(target,name);
		this.seats=seats;
	}


}



//火车票网

class Web12306  implements Runnable {
	private int available;//可用位子
	private String name;
	public Web12306(int available, String name){
		this.available=available;
		this.name=name;
	}
	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	//购票  加入同步
	public synchronized boolean bookTickets(int seats) {
		System.out.println("可用位置为:\t"+available);
		
		//相减
		
		if (seats>available) {
//			System.out.println("购票失败");
			return false;
		}else {
			available-=seats;
//			System.out.println("购票成功");
			return true;
		}
	}//bookTicket

	@Override
	public void run() {
		   	Passenger p=(Passenger)Thread.currentThread();
			boolean flag=this.bookTickets(p.seats);
			if (flag) {
				System.out.println("出票成功!"+Thread.currentThread().getName()+"-->购买了 "+p.seats+" 张票");
			}else {
				System.out.println("出票失败,位置不够!");
		}//synchronized
		
	}
		
}
