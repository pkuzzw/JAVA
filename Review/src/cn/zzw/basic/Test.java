package cn.zzw.basic;
/**
 * 测试Override和Overload
 * @author zzw
 *
 */
public class Test {
	public static void main(String[] args) {
		Animal a=new Animal();
		Animal b=new Dog();
		a.nihao();
		a.sayhello("a");
		b.sayhello("b");
	}

}
class Animal{
	public Animal() {
		System.out.println("new a Animal ");
	}
	public void sayhello() {
		System.out.println("hello, i am a animal");
	}
	public void sayhello(String name) {
		System.out.println("hello, My name is "+name);
	}
	@SuppressWarnings("unused")
	private void hi() {
		System.out.println("hi");
	}
	protected void nihao() {
		System.out.println("nihao");
	}
}
class Dog extends Animal{
	public Dog() {
		this(1);
		System.out.println("new a Dog without name");

	}
	public Dog(String name) {
		System.out.println("new a Dog with name="+name);
	}
	public Dog(int i) {
		System.out.println("new a Dog with int="+i);
	}
	
	@Override
	public void sayhello() {
		System.out.println("hello, I am a dog");
	}
	@Override
		public void sayhello(String name) {
		System.out.println("啊啊啊,我是子类啊");
		}
	public void wangwang() {
		System.out.println("wangwang");
	}
}