package cn.zzw.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *测试Statement 执行SQL语句 以及SQL注入问题 
 * 
 * @author zzw
 *
 */

public class Demo02 {
	public static void main(String[] args) {
	//加载驱动类
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("加载成功");
		try {
			//建立连接  连接对象内部其实包含了Socket连接   比较耗时 比较耗时  比较耗时 这是Connecion对象管理的一个要点
			//真正开发中 为了提高连接效率都会使用连接池
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC", "root", "123");
			Statement statement=conn.createStatement();
			String sql="";
//			String sql=" Insert into students(Number,Name,Home,Age) VALUES ('4','WANG','GUANGZHOU','33');"; 
//			statement.execute(sql);
			
			//测试SQL注入
			//有了SQL注入漏洞,会在传入参数的时候加入恶意代码,危害数据库
			sql="delete from students where NAME='LIU'";
			statement.execute(sql);
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
