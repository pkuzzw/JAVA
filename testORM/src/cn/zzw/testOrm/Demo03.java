package cn.zzw.testOrm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 测试ORM映射
 * 
 * 使用JavaBean对象封装一条记录
 * 
 * @author zzw
 *
 */

public class Demo03 {
	
	/**
	 * 利用Map<Stirng,Objec>封装一条记录
	 */
	public static void test() {//利用map封装一条记录
		Connection conn=JDBCUtil.Connect("sorm", "root","123456");
		PreparedStatement ps=null;
		ResultSet set=null;
		Emp emp=null;
		System.out.println("连接成功,开始查询");
		try {
			String sql="select * from emp where id=? ";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "5");
			set=ps.executeQuery();
			emp=new Emp();
			while(set.next()) {
				emp.setAge(set.getInt("age"));
				emp.setBirthday(set.getDate("birthday"));
				emp.setDepId(set.getInt("deptId"));
				emp.setEnmName(set.getString("empName"));
				emp.setId(set.getInt("id"));
				emp.setSalary(set.getInt("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(set, ps, conn);
		}
		if (emp!=null) {
			System.out.println("查询到的一条记记录为:\n"+emp.toString());
		}else {
			System.out.println("没找到数据");
		}
	}
	/**
	 * 利用List<Emp> 封装多条数据记录
	 */
	
	public static void test1() {
		Connection conn=JDBCUtil.Connect("sorm", "root","123456");
		PreparedStatement ps=null;
		ResultSet set=null;
		Emp emp=null;
		List<Emp> list=null;
		
		System.out.println("连接成功,开始查询");
		try {
			String sql="select * from emp where id>=? ";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "3");
			set=ps.executeQuery();
			list=new ArrayList< Emp >();
			while(set.next()) {
				list.add(new Emp(set.getInt("id"),set.getString("empName"), set.getInt("salary"), set.getInt("age"), set.getDate("birthday"), set.getInt("deptId")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(set, ps, conn);
		}
		//遍历List查看找到的数据
		System.out.println("通过list找到了"+list.size()+"个数据");
		for (Emp e : list) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * 利用Map<String,Map<String,Object>> 封装多条记录
	 */
	public static void test2() {
		Connection conn=JDBCUtil.Connect("sorm", "root","123456");
		PreparedStatement ps=null;
		ResultSet set=null;
		Map<String,Object> map=null;
		Map<String,Map<String,Object> > Maps = null;
		
		System.out.println("连接成功,开始查询");
		try {
			String sql="select * from emp where id>=? ";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "1");
			Maps=new HashMap<String, Map<String,Object>>();
			set=ps.executeQuery();
			while(set.next()) {
				map=new HashMap<String,Object>();
				map.put("empName", set.getString("empName"));
				map.put("Salary", set.getInt("salary"));
				map.put("age", set.getInt("age"));
				Maps.put(set.getString("empName"), map);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(set, ps, conn);
		}
		System.out.println("查询到的数据为:"+Maps.size()+"个");
		//遍历一行,显示数据
		for (String empName : Maps.keySet()) {
			System.out.println("empName:"+empName+"\tdata:"+Maps.get(empName));
			
		}
	}
	
	public static void main(String[] args) {
		test1();
		
	}
	

}
