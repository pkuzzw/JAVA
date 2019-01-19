package cn.zzw.synchronize;

/**
 * 线程安全:在并发时保证数据的正确性 效率尽可能高
 * synchronized
 * 同步方法
 * 同步块  目标更明确
 * @author zzw
 *
 */

public class SynBlockTest01 {
	
	public static void main(String[] args) {
		Account account=new Account(170, "结婚礼金");
		SynDrawing husband=new SynDrawing(account, 80,"丈夫");
		SynDrawing wife=new SynDrawing(account, 90,"妻子");
		SynDrawing chil=new SynDrawing(account, 20, "孩子");
		husband.start();
		wife.start();
		chil.start();
	}

}


//模拟取款 线程安全

class SynDrawing extends Thread{
	Account account;//取钱的账户
	int drawingMoney;//取的钱数
	int packetTotal;//口袋的钱
	
	
	public SynDrawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
	@Override
	public void run() {
		test();
	}
	
	//用同步块 目标锁定Account
	public void test() {
		synchronized (account) {
			//提高性能
			if (account.getMoney()<=0) {
				return;
			}
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
	
}

