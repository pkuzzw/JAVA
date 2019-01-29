package cn.zzw.testOrm;

import java.sql.Date;

/**
 * 
 * JAVABEAN
 * 
 * 表结构和类要对应
 * @author zzw
 *
 */

public class Emp {
	private Integer id;
	private String empName;
	private Integer salary;
	private Integer age;
	private Date birthday;
	private Integer deptId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEnmName() {
		return empName;
	}
	public void setEnmName(String enmName) {
		this.empName = enmName;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getDepId() {
		return deptId;
	}
	public void setDepId(Integer deptId) {
		this.deptId = deptId;
	}

	public Emp() {
	}
	public Emp(Integer id, String enmName, Integer salary, Integer age, Date birthday, Integer deptId) {
		this.id = id;
		this.empName = enmName;
		this.salary = salary;
		this.age = age;
		this.birthday = birthday;
		this.deptId = deptId;
	}
	public Emp(String enmName, Integer salary, Integer age, Date birthday, Integer deptId) {
		this.empName = enmName;
		this.salary = salary;
		this.age = age;
		this.birthday = birthday;
		this.deptId = deptId;
	}
	public String toString() {
		return "id:"+id+"\tName:"+empName+"\tage:"+age+"\tbirthday:"+birthday+"\tdeptId:"+deptId+"\tsalary:"+salary;
	}
	

}
