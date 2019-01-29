package cn.zzw.abstractFactory;

public interface AbstractCarFactory {
	Engine createEngine();
	Seat createSeat();
	Tyre createTyre();

}
