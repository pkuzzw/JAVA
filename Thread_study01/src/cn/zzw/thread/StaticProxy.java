package cn.zzw.thread;


/**
 * 静态代理 
 * 两个角色都需要实现一个接口
 *  
 *  公共接口;
 *  1 真实角色
 *  2 代理角色
 *  
 * @author zzw
 *
 */

public class StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();
		//new Thread(线程对象).start()
	}

}

interface Marry{
	void happyMarry();
}

class You implements Marry{

	@Override
	public void happyMarry() {
		System.out.println("You are Married!");
	}
	
}


//代理角色
class WeddingCompany implements Marry{
	
	//真实角色
	private Marry target;
	public WeddingCompany(Marry target) {
		this.target=target;
	}
	public WeddingCompany() {
	}
	@Override
	public void happyMarry() {
		ready();
		this.target.happyMarry();
		after();
		
	}
	public void ready() {
		System.out.println("Preparing for the Wedding Party");
	}
	public void after() {
		System.out.println("After Wedding!");
	}
	
}
