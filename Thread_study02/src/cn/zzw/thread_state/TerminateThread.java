package cn.zzw.thread_state;
/**
 * 终止线程的两种方式
 * 1 线程正常执行完毕-->次数
 * 2 外部干涉--> 加入标识
 * 不要使用stop() destroy()
 * @author zzw
 *
 */

public class TerminateThread implements Runnable{
	//加入标记  标记线程体是否可以运行
	private boolean flag=true;
	private int count;
	public TerminateThread() {
		this.count=0;
	}
	

	@Override
	public void run() {
		//关联标识  true-->运行   false-->停止
		while (flag) {
			System.out.println("Now I am testing stop thread\t"+(count++));
		}
	}
	
	public void stop() {
		this.flag=false;
	}
	
	
	public static void main(String[] args) {
		TerminateThread tt=new TerminateThread();
		//线程启动
		new Thread(tt).start();
		for (int i = 0; i < 100; i++) {
			if (i==88) {
				tt.stop();
				System.out.println("线程终止");
			}
			System.out.println("i="+i);
		}
	}

}
