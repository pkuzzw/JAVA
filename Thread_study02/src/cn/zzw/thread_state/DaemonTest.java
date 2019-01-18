package cn.zzw.thread_state;
/**
 * 守护线程: 是为用户线程服务的;JVM停止不用等待守护线程完毕
 * 用户线程: 默认情况下都是用户线程,JVM等用户线程执行完毕之后才会停止
 */

public class DaemonTest {

	public static void main(String[] args) {
		God god=new God();
		You you=new You();
		Thread t=new Thread(god);
		//将用户线程调整为守护
		t.setDaemon(true);
		t.start();
		new Thread(you).start();
		
	}
}

class You implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println("HappyLife...."+i);
		}
		System.out.println("oooooooo....");
	}
}

class God implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.println("Blesss you.................."+i);
		}
	}
}