package cn.zzw.thread;


/**
 * 模拟龟兔赛跑
 * @author zzw
 *
 */

public class Racer implements Runnable{

	private static String winner;
	@Override
	public void run() {
		//模拟休息
		for (int steps = 1;  steps <= 100; steps++) {
			if (Thread.currentThread().getName().equals("兔兔0001")&& ((steps%50)==0)) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println(Thread.currentThread().getName()+"-->"+steps);
			boolean flag=gameOver(steps);
			if (flag) {
				break;
			}
		}
	}
	
	private boolean gameOver(int steps) {
		if (winner!=null) {//存在胜利者
			return true;
		}else {
			if (steps==100) {
				winner=Thread.currentThread().getName();
				System.out.println("Winner is \t"+winner);
				return true;
			}
		}
		
		
		return false;
	}
	
	public static void main(String[] args) {
		Racer racer=new Racer();
		new Thread(racer,"兔兔0001").start();
		new Thread(racer,"阿龟").start();

		
	}

}
