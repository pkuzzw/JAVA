package cn.zzw.server.basic;

public class Person {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "name:\t"+name+"\tage:\t"+age;
		
	}
	public static void main(String[] args) {
		Person p=new Person();
		p.setAge(18);
		p.setName("zzw");
		System.out.println(p);
	}

	
}
