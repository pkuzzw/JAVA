package cn.zzw.thread;
/**
 * 创建线程方式一
 * 1 创建子类继承Thread
 * 2 重写run()方法
 * 3 启动用start()
 * @author zzw
 *
 */

public class StartThread extends Thread{
	/**
	 * 线程入口点
	 */
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 20; i++) {
			System.out.println("一边听歌");
		}
	}
	
	public static void main(String[] args) {
		//启动线程
		//第一步创建子类对象,调用子类对象的Start方法
		StartThread st=new StartThread();
		st.start();//不保证立即运行,由CPU进行调度
		for (int i = 0; i < 20; i++) {
			System.out.println("一边写代码");
		}
	}
}
