package cn.zzw.testinterface;

public class Test implements NameOfInterface{
	private String name;
	public Test() {
		//无参构造函数
	}
	public Test(String name) {
		System.out.println("Initializing Test with name:\t"+name);
		this.name=name;
		
	}
	
	public static void main(String[] args) {
		System.out.println("-----------------Test---------------");
		Test t=new Test();
		t.shout();
		t.eat();
		
		Test t1=new Test("zzw");
		t1.eat();
		t1.shout();
		
		System.out.println("---------------Test_B-------------------");
		
		Test_B tb=new Test_B() {			
			@Override
			public void shout() {
				System.out.println("this is Test_B shouting");
			}
		};
		tb.shout();
		tb.eat();
		
		System.out.println("-----------Employee----------");
		Employee employee=new RionEmployee("zzw", "ChengShan Road", 19008);
		employee.oneAddress();
		employee.testMethod();
	}

	@Override
	public void eat() {
		System.out.println("  Eating ");
	}

	@Override
	public void shout() {
		System.out.println("   Shouting   ");
		
	}

}

abstract class Test_B implements NameOfInterface{
	@Override
	public void eat() {
		System.out.println("this is class Test_B eating");
		
	}
	
}
