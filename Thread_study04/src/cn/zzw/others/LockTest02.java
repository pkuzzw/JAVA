package cn.zzw.others;
/**
 * 可重入锁: 锁可以延续使用
 * @author zzw
 *
 */

public class LockTest02 {
	Lock lock= new Lock();
	public void a() throws InterruptedException {
		lock.lock();
		doSomething();
		lock.unlock();
	}
	//不可重入
	public void doSomething() throws InterruptedException {
		lock.lock();
		//.............do Something
		lock.unlock();
		
	}
	public static void main(String[] args) throws InterruptedException {
		LockTest02 test=new LockTest02();
		test.a();
		test.doSomething();
		

		
	}

	
	
}

class Lock {
	//是否占用
	private boolean isLocked=false;
	//使用锁
	public synchronized void lock() throws InterruptedException {
		while (isLocked) {//被占用了,一直等待
			wait();
		}
		//之前没被占用,现在已经被占用了,设置占用标志
		isLocked=true;
	}
	
	//释放锁
	public synchronized void unlock() {
		isLocked=false;
		notify();
	}
}