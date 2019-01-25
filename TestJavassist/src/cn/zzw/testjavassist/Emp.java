package cn.zzw.testjavassist;

public class Emp {
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
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	public Emp(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	

}
