package cn.zzw.synchronize;


/**
 * 快乐影院
 * @author zzw
 *
 */

public class HappyCinema {
	public static void main(String[] args) {
		Cinema c=new Cinema(5, "海淀剧院");
		new Thread(new Customer(c, 2),"A").start();;
		new Thread(new Customer(c, 5),"B").start();;
		
	}

}


//顾客
class Customer implements Runnable{
	Cinema cinema;
	int seats;
	public Customer(Cinema cinema, int seats) {
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
class Cinema{
	private int available;//可用位子
	private String name;
	public Cinema(int available, String name){
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

	//购票
	public boolean bookTickets(int seats) {
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
		
	}
	
	
	
	
	
}
