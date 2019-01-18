package cn.zzw.thread;

public class StopThread implements Runnable{
	private boolean flag;
	private int count;
	public StopThread() {
		this.flag=true;
		this.count=0;
	}
	

	@Override
	public void run() {

		while (flag) {
			System.out.println("Now I am testing stop thread\t"+(count++));
		}
	}
	
	public void stop() {
		this.flag=false;
	}
	
	
	public static void main(String[] args) {
		StopThread st=new StopThread();
		new Thread(st).start();
		for (int i = 0; i < 100; i++) {
			if (i==50) {
				st.stop();
				
			}
			System.out.println("i="+i);
		}
	}

}
