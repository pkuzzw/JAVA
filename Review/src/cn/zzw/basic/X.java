package cn.zzw.basic;

public class X implements Runnable {
	private int x=0;
	private int y=0;
	public static void main(String [] args) {
		X that = new X();
		(new Thread(that)).start();
		(new Thread(that)).start();
	}
	public synchronized void run( ){
		for (;;) {
			x++;
			y++;
			System.out.println("x="+x+",y="+y);
		}
	}
}