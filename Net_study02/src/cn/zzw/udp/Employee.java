package cn.zzw.udp;
//javabean封装数据
public class Employee implements java.io.Serializable{
	private transient String nameString;
	private int Age;
	public Employee() {
		
	}
	public Employee(String nameString, int age) {
		super();
		this.nameString = nameString;
		Age = age;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	@Override
	public String toString() {
		return "EmployeeName:\t"+this.nameString+"\nEmployeeAge:\t"+this.Age;
		
	}
	
}
