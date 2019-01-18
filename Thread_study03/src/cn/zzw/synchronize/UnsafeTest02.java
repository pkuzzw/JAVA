package cn.zzw.synchronize;

/**
 * 线程不安全: 取钱
 * 
 * @author zzw
 *
 */

public class UnsafeTest02 {
	
	public static void main(String[] args) {
		Account account=new Account(100, "结婚礼金");
		
		Drawing husband=new Drawing(account, 80,"丈夫");
		Drawing wife=new Drawing(account, 90,"妻子");
		husband.start();
		wife.start();
		
		
	}

}

//模拟取款

class Drawing extends Thread{
	Account account;//取钱的账户
	int drawingMoney;//取的钱数
	int packetTotal;//口袋的钱
	
	
	public Drawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
	@Override
	public void run() {
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

