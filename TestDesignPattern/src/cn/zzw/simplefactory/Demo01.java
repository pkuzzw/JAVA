package cn.zzw.simplefactory;
/**
 * 测试在没有工厂模式的情况下
 * 
 * @author zzw
 *
 */

public class Demo01 {//调用者
	
	public static void main(String[] args) {
		Car  c1 = new Audi();
		Car  c2 = new Benz();
		c1.run();
		c2.run();
	}

}
