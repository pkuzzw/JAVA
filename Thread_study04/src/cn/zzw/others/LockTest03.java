package cn.zzw.others;
/**
 * 可重入锁: 锁可以延续使用+ 计数器
 * 
 * 改为 可重入锁
 * @author zzw
 *
 */

public class LockTest03 {
	ReLock lock= new ReLock();
	public void a() throws InterruptedException {
		lock.lock();
		System.out.println("lockcount:\t function  a() 1\t"+lock.getCount());
		doSomething();
		lock.unlock();
		System.out.println("lockcount:\tfunction  a() 2\t"+lock.getCount());

	}
	//不可重入
	public void doSomething() throws InterruptedException {
		lock.lock();
		System.out.println("lockcount:\t function  doSomething() 1\t"+lock.getCount());

		//.............do Something
		lock.unlock();
		System.out.println("lockcount:\t function  doSomething() 2\t"+lock.getCount());

		
	}
	public static void main(String[] args) throws InterruptedException {
		LockTest03 test=new LockTest03();
		test.a();
		test.doSomething();
		Thread.sleep(1000);
		System.out.println("testcount=\t"+test.lock.getCount());
	}
}

class ReLock {
	//是否占用
	private boolean isLocked=false;
	//存储线程
	private Thread lockedBy=null;
	//计数器
	private int count=0;
	public int getCount() {
		return count;
	}

	//使用锁
	public synchronized void lock() throws InterruptedException {
		Thread temp=Thread.currentThread();
		while (isLocked && lockedBy!=temp) {//被占用了,一直等待
			wait();
		}
		//之前没被占用,现在已经被占用了,设置占用标志
		isLocked=true;
		lockedBy=temp;
		count++;
	}
	
	//释放锁
	public synchronized void unlock() {
		if (Thread.currentThread()==lockedBy) {
			count--;
			if (count==0) {
				isLocked=false;
				notify();
				lockedBy=null;
			}
		}
	}
}