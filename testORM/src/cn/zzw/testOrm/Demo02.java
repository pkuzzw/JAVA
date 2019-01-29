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
 * 测试使用Map<String,Object>来封装一条记录
 * 使用List<  Map<String,Object>  > list封装多条记录
 * 
 * @author zzw
 *
 */

public class Demo02 {
	
	/**
	 * 利用Map<Stirng,Objec>封装一条记录
	 */
	public static void test() {//利用map封装一条记录
		Connection conn=JDBCUtil.Connect("sorm", "root","123456");
		PreparedStatement ps=null;
		ResultSet set=null;
		Map<String,Object> map=null;
		System.out.println("连接成功,开始查询");
		try {
			String sql="select * from emp where id=? ";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "1");
			set=ps.executeQuery();
			while(set.next()) {
				map=new HashMap<String,Object>();
				map.put("empName", set.getString("empName"));
				map.put("Salary", set.getInt("salary"));
				map.put("age", set.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(set, ps, conn);
		}
		System.out.println("查询到的一条记为;"+map.toString());
	}
	/**
	 * 利用list<map<String,Object>>封装多条记录
	 */
	
	public static void test1() {
		Connection conn=JDBCUtil.Connect("sorm", "root","123456");
		PreparedStatement ps=null;
		ResultSet set=null;
		Map<String,Object> map=null;
		List< Map<String,Object> > list=null;
		
		System.out.println("连接成功,开始查询");
		try {
			String sql="select * from emp where id>=? ";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "1");
			set=ps.executeQuery();
			list=new ArrayList< Map<String, Object> >();
			while(set.next()) {
				map=new HashMap<String,Object>();
				map.put("empName", set.getString("empName"));
				map.put("Salary", set.getInt("salary"));
				map.put("age", set.getInt("age"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(set, ps, conn);
		}
	
		//遍历List查看找到的数据
		System.out.println("通过list找到了"+list.size()+"个数据");
		for (Map<String, Object> map2 : list) {
			System.out.println(map2.toString());
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
//		test();
//		test1();
		test2();
		
	}
	

}
