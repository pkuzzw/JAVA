package cn.zzw.abstractFactory;


/**
 * 测试抽象工厂模式
 * @author zzw
 *
 */


public class Client {
	public static void main(String[] args) {
		AbstractCarFactory factory=new LowCarFactory();
		Engine engine=factory.createEngine();
		Tyre tyre=factory.createTyre();
		Seat seat=factory.createSeat();
		tyre.show();
		seat.show();
		engine.show();

		
	}
	

}
