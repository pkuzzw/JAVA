package cn.zzw.thread_state;

public class BlockedJoin02 {
	public static void main(String[] args) {
		System.out.println("爸爸和儿子买烟的故事");
		new Thread(new Father()).start();
	}

}

class Father extends Thread{
	@Override
	public void run() {
		System.out.println("我让儿子去买烟");
		Thread t=new Thread(new Son());
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("拿到烟了,准备抽烟");
	}
	
}
class Son extends Thread{

	
	@Override
	public void run() {
		System.out.println("我替爸爸去买烟了\n路边有个游戏厅,去玩了十秒");
		for (int i = 0; i < 10; i++) {
			System.out.println((i+1)+"秒过去了");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("想起来买烟了,赶紧去买烟\n买完烟回家");
	}
	
}
