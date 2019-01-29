package cn.zzw.simplefactory;
/**
 * 使用简单工厂模式
 * @author zzw
 *
 */

public class Demo02 {//调用者
	
	public static void main(String[] args) {
		Car c1=CarFactory.createCar("奥迪");
		Car c2=CarFactory.createCar("奔驰");
		c1.run();
		c2.run();
		System.out.println("test-----------------");

		Car c3=CarFactory2.createAudi();
		Car c4=CarFactory2.createBenz();
		c3.run();
		c4.run();
	}

}
