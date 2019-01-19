package cn.zzw.cooperation;
/**
 * 协作模型: 生产者 消费者
 * 实现方式一 管程法
 *	 四个角色
 * 1	生产者
 * 2	消费者
 * 3	缓冲区
 * 4	数据
 * 
 * 
 * 借助缓冲区
 * @author zzw
 *
 */

public class CoTest01 {
	
	public static void main(String[] args) {
		SynContainer container=new SynContainer();
		Productor p=new Productor(container);
		Consumer c=new Consumer(container);
		p.start();
		c.start();
		
	}

}

//生产者
class Productor extends Thread{
	SynContainer container;
	public Productor(SynContainer container) {
		super();
		this.container = container;
	}
	@Override
	public void run() {//开始生产
		for (int i = 0; i < 1000; i++) {
			System.out.println("生产第 "+i+" 个馒头");
			container.push(new StreamedBun(i));
		}
	}
}
//消费者
class Consumer extends Thread{
	SynContainer container;
	public Consumer(SynContainer container) {
		super();
		this.container = container;
	}




	@Override
	public void run() {//开始消费
		for (int i = 0; i < 1000; i++) {
			System.out.println("消费第 "+container.pop().id+" 个馒头");
		}
		
	}
}
//缓冲区
class SynContainer{
	StreamedBun[] buns=new StreamedBun[10];//存储容量
	int count=0;//计数器
	//存储  生产 
	//加入并发
	public synchronized void push(StreamedBun bun) {
		//何时可以生产 容器中存在剩余空间才可以
		//不能生产
		if (count==buns.length) {
			try {
				this.wait();//线程阻塞  消费者通知生产,接触阻塞
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//存在空间,可以生产
		buns[count]=bun;
		count++;
		//存在数据了,可以进行消费
		this.notify();
	}
	
	
	//获取
	public synchronized StreamedBun pop() {
		//何时消费 判断容器中是否存在数据,如果没有数据 等待
		
		if (count<1) {
			System.out.println("馒头不够了");
			try {
				this.wait();//此时线程阻塞  生产者通知消费 接触
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count--;
		StreamedBun bun=buns[count];
		this.notify();//存在空间了,唤醒生产者进行生产,通知进行生产
		return bun;
	}

	
}
//数据-->馒头
class StreamedBun{
	int id;
	public StreamedBun(int id) {
		this.id=id;
	}
	
}
















