package cn.zzw.testinterface;

public class RionEmployee extends Employee {

	public RionEmployee(String name, String address, int number) {
		super(name, address, number);
	}
	@Override
	public void oneAddress() {
        System.out.println("你的名字是：" + getName());
        System.out.println("你的地址是：" + getAddress());
        System.out.println("你的数字是：" + getNumber());
	}

}
