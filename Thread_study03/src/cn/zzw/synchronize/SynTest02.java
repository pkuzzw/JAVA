package cn.zzw.synchronize;

/**
 * 线程安全:在并发时保证数据的正确性 效率尽可能高
 * synchronized
 * 同步方法
 * 同步块
 * @author zzw
 *
 */

public class SynTest02 {
	
	public static void main(String[] args) {
		Account account=new Account(100, "结婚礼金");
		SafeDrawing husband=new SafeDrawing(account, 80,"丈夫");
		SafeDrawing wife=new SafeDrawing(account, 90,"妻子");
		husband.start();
		wife.start();
	}

}


//模拟取款

class SafeDrawing extends Thread{
	Account account;//取钱的账户
	int drawingMoney;//取的钱数
	int packetTotal;//口袋的钱
	
	
	public SafeDrawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
	@Override
	public void run() {
		test();
	}
	
	//目标不对称,锁定失败,这里不是锁this应该锁定对象account
	public synchronized void test() {
		if (account.getMoney()-drawingMoney<0) {
			System.out.println("钱不够了");
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		account.setMoney(account.getMoney()-drawingMoney);
		packetTotal+=drawingMoney;
		System.out.println(this.getName()+"\t账户余额为:\t\t"+account.getMoney());
		System.out.println(this.getName()+"\t口袋的钱为:\t\t"+packetTotal);
	}
	
}

