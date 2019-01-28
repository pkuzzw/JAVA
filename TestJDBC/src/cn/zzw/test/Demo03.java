package cn.zzw.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *测试Prepared Statement的基本用法
 * 
 * @author zzw
 *
 */

public class Demo03 {
	public static void main(String[] args) {
	//加载驱动类
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("加载成功");
		try {
			//建立连接  连接对象内部其实包含了Socket连接   比较耗时 比较耗时  比较耗时 这是Connecion对象管理的一个要点
			//真正开发中 为了提高连接效率都会使用连接池
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC", "root", "123");
			
			String sql="insert into students (Number,Name,Age) VALUES (?,?,?) ";//?占位符
			PreparedStatement ps=conn.prepareStatement(sql);
//			ps.setString(1, "11");
//			ps.setString(2, "LIU");
			
			ps.setObject(1, "13");
			ps.setObject(2, "小华");
			ps.setObject(3, "22");
			
//			ps.execute();      //返回boolean,是否成功
//			ps.executeUpdate();//返回插入了多少行
			System.out.println("插入一行记录");
			System.out.println(ps.executeUpdate());
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
