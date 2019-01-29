package cn.zzw.factorymethod;

public class BenzFacory implements CarFactory {
	@Override
	public Car createCar() {
		return new Benz();
	}
}
