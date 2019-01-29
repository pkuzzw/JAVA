package cn.zzw.simplefactory;
/**
 * 创建者 
 * 专门用来创建对象
 * @author zzw
 *
 */

public class CarFactory2 {
	public static Car createAudi() {
		return new Audi();
	}
	public static Car createBenz() {
		return new Benz();
	}

}
