package cn.zzw.javabean;

public class User {
	private int id;
	private int age;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		System.out.println("这是一个有参数的构造器");
	}
	//javabean必须有一个无参构造器
	public User() {
		System.out.println("构造一个User对象");
	}
	
	private User(String nameString) {
		this.name=nameString;
	}
	
	@SuppressWarnings("unused")
	private void test() {
		System.out.println("test");
	}
	
	@Override
	public String toString() {
		return "name=\t"+name+"\nage=\t"+age+"\nid=\t"+id;
	}

}
