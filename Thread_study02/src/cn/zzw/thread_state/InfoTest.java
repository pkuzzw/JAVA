package cn.zzw.thread_state;
/**
 * 测试线程的其他常用方法
 * isAlive()
 * setName()
 * getName()
 * currentThread() 取得正在运行的线程对象,也就是获取本身自己
 * @author zzw
 *
 */

public class InfoTest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().isAlive());
		//设置名称 : 真实名称+代理角色
		MyInfo mi=new MyInfo("战斗机");
		Thread t=new Thread(mi);
		t.setName("测试");
		t.start();
		System.out.println(t.isAlive());
		Thread.sleep(1000);
		System.out.println(t.isAlive());
//		new Thread(mi).start();
	}

}

class MyInfo implements Runnable{
	private String name;
	public MyInfo(String name) {
		this.name=name;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--->"+name);
	}
}
