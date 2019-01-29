package cn.zzw.simplefactory;
/**
 * 创建者 
 * 专门用来创建对象
 * @author zzw
 *
 */

public class CarFactory {
	public static  Car createCar(String type) {
		if ("奥迪".equals(type)) {
			return new Audi();
		}else if ("奔驰".equals(type)) {
			return new Benz();
		}else {
			return null;
		}//if
	}//createCar

}
