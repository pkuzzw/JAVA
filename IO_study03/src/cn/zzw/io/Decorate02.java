package cn.zzw.io;


/**
 * 实现放大器对声音的放大功能
 * 1 抽象组件:需要装饰的抽象对象(一般是接口或者抽象父类)
 * 2 具体组件:需要装饰的对象
 * 3 抽象装饰类:内部包含了对抽象组件的引用以及装饰者共有的方法
 * 4 具体的装饰者:装饰类,被装饰对象
 * 
 * 
 * 
 * @author zzw
 *
 */

public class Decorate02 {
	public static void main(String[] args) {
		Drink coffee=new Coffee();
		Drink sugar=new Sugar(coffee);//装饰
		System.out.println("sugar.info"+"--->"+sugar.info()+"\t sugar cost-->"+sugar.cost());
		
		Drink milk=new Milk(coffee);//装饰
		System.out.println("milk.info"+"--->"+milk.info()+"\t milk cost-->"+milk.cost());

	}

}

//抽象组件
interface Drink{
	double cost();//费用
	String info();//名字
}

//具体组件
class Coffee implements Drink{
	private String name="原味咖啡";
	private int price=10;
	@Override
	public double cost() {
		return this .price;
	}

	@Override
	public String info() {
		return name;
	}
}


//抽象装饰类
abstract class Decorate implements Drink{
	
	//对抽象组件的引用
	private Drink drink;
	public  Decorate(Drink drink) {
		this.drink=drink;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.drink.cost();
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return this.drink.info();
	}
	
}
//具体装饰类
class Milk extends Decorate{

	public Milk(Drink drink) {
		super(drink);
	}
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()*4;
	}

	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"加入了牛奶";
	}
	
}

//具体装饰类
class Sugar extends Decorate{

	public Sugar(Drink drink) {
		super(drink);
	}
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()*2;
	}

	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"加入了蔗糖";
	}
	
}




























