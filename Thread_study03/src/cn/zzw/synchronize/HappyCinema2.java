package cn.zzw.synchronize;

import java.util.ArrayList;
import java.util.List;

/**
 * 快乐影院
 * 使用同步块实现同步功能
 * @author zzw
 *
 */

public class HappyCinema2 {
	public static void main(String[] args) {
		//准备好可用位置
		List<Integer> available=new ArrayList<Integer>();
		available.add(1);
		available.add(2);
		available.add(3);
		available.add(4);
		available.add(5);
		available.add(6);
		available.add(7);
		available.add(8);
		available.add(9);
		available.add(10);
		available.add(11);
		
		//顾客需要的位置
		List<Integer> seats1=new ArrayList<Integer>();
		List<Integer> seats2=new ArrayList<Integer>();
		seats1.add(2);
		seats1.add(10);
		seats2.add(10);
		seats2.add(8);
		seats2.add(4);
		seats2.add(5);
		
		HaCinema c=new HaCinema(available, "海淀剧院");
		new Thread(new HappyCustomer(c, seats1),"A").start();;
		new Thread(new HappyCustomer(c, seats2),"B").start();;
		
	}

}


//顾客
class HappyCustomer implements Runnable{
	HaCinema cinema;
	List<Integer> seats;
	public HappyCustomer(HaCinema cinema, List<Integer> seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}


	@Override
	public void run() {
		synchronized (cinema) {
			boolean flag=cinema.bookTickets(seats);
			if (flag) {
				System.out.println("出票成功!"+Thread.currentThread().getName()+"-->购买了 "+seats+" 张票");
			}else {
				System.out.println("出票失败,位置不够!");
			}
		}//synchronized
	}
	
}





//影院
class HaCinema{
	private List<Integer> available;//可用位子
	private String name;
	public HaCinema(List<Integer> available, String name){
		this.available=available;
		this.name=name;
	}
	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Integer> getAvailable() {
		return available;
	}

	public void setAvailable(List<Integer> available) {
		this.available = available;
	}

	//购票
	public boolean bookTickets(List<Integer> seats) {
		System.out.println("可用位置为:\t"+available);
		List<Integer> copy=new ArrayList<Integer>();
		//拷贝备份
		copy.addAll(available);
		//相减,减去客户订购的位置
		copy.removeAll(seats);
		
		
		//判断大小
		if (available.size()-copy.size()!=seats.size()) {
			return false;
		}
		//成功
		available=copy;
		return true;

		
	}
	
	
	
	
	
}
