package cn.zzw.annotation;

@StudentTable("tb_student")
public class Student {
	@StudentField(columnName="name",type="varchar",length=10)
	private String name;
	@StudentField(columnName="age",type="varchar",length=3)
	private int age;
	@StudentField(columnName="id",type="int",length=10)
	private int id;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
