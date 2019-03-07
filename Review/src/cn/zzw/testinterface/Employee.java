package cn.zzw.testinterface;
/**
 * 这是一个抽象类 ,除了不能被实例化  其他的和普通类无差异
 * 
 * @author zzw
 *
 */

public abstract class Employee {
	private String name;
	private String address;
	private int number;
	public Employee(String name, String address, int number) {
		System.out.println("构造一个雇员对象");
		this.name = name;
		this.address = address;
		this.number = number;
	}
	
	public void oneAddress() {
		System.out.println("Name:\t"+this.name+"\nAddress:\t"+this.address+"\nNumber:\t"+this.number);
	}
	public void testMethod() {
		System.out.println("This is a test Method to test Abstract Class");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	

}
