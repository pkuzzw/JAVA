package cn.zzw.factorymethod;
/**
 * 工厂方法的使用
 * @author zzw
 *
 */

public class Client {
	public static void main(String[] args) {
		Car c1=new AudiFactory().createCar();
		Car c2=new BenzFacory().createCar();
		Car c3=new BmwFactory().createCar();
		c1.run();
		c2.run();
		c3.run();
	
	}

}
