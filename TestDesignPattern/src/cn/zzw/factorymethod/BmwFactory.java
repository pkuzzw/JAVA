package cn.zzw.factorymethod;

public class BmwFactory implements CarFactory{

	@Override
	public Car createCar() {
		return new Bmw();
	}
}
