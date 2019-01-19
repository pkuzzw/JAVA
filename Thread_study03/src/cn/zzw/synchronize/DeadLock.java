package cn.zzw.synchronize;
/**
 * 死锁:过多的同步可能造成相互不释放资源
 * 从而相互等待,一般发生于同步中此佑多个对象的锁
 * 
 * 
 * 
 * 避免:不要在同一个代码中同时持有多个对象的锁
 * 
 * 
 * @author zzw
 *
 */

public class DeadLock {
	public static void main(String[] args) {
		Markup g1=new Markup(1, "王菲");
		Markup g2=new Markup(0, "张柏芝");
		g1.start();
		g2.start();
	}

}

//口红
class Lipstick{
	
}


//镜子
class Mirror{
	
}

//化妆
class Markup extends Thread{
	static Lipstick lipstick=new Lipstick();
	static Mirror mirror= new Mirror();
	
	
	
	//选择
	int choice;
	//名字
	String girl;
	public Markup(int choice,String girl) {
		this.choice = choice;
		this.girl=girl;
	}

	//化妆
	//相互持有对方的对象锁-->可能造成死锁
	private void makeup() {
		if (choice==0) {
			synchronized (lipstick) {//获得口红的锁
				System.out.println(this.girl+"获得口红");
				//1秒后想拥有镜子的锁
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//获得镜子的锁
//				synchronized (mirror) {
//				System.out.println(this.girl+"获得镜子");	
//				}
			}
			synchronized (mirror) {
			System.out.println(this.girl+"获得镜子");	
			}
		}else {
			synchronized (mirror) {	//获得镜子的锁
				System.out.println(this.girl+"获得镜子");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//获得口红的锁
//				synchronized (lipstick) {
//				System.out.println(this.girl+"获得口红");	
//				}
			}
			synchronized (lipstick) {
			System.out.println(this.girl+"获得口红");	
			}
		}

		
	}


	@Override
	public void run() {
		makeup();
	}
}


















