package cn.zzw.testOrm;
/**
 *
 * 测试 JavaBean
 * 类结构与表结构一样
 * @author zzw
 *
 */

public class Dept {
	private Integer id;
	private String dname;
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Dept() {
		
	}
	public Dept(Integer id, String dname, String address) {
		this.id = id;
		this.dname = dname;
		this.address = address;
	}
	public Dept(String dname, String address) {
		this.dname = dname;
		this.address = address;
	}
	
	

}
