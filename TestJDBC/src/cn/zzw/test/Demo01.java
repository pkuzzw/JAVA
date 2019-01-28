package cn.zzw.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试JDBC
 * 加载JDBC驱动程序 建立连接
 * @author zzw
 *
 */

public class Demo01 {
	public static void main(String[] args) {
	//加载驱动类
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("加载成功");
		try {
			//建立连接  连接对象内部其实包含了Socket连接   比较耗时 比较耗时  比较耗时 这是Connecion对象管理的一个要点
			//真正开发中 为了提高连接效率都会使用连接池
			long start =System.currentTimeMillis();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC", "root", "123");
			long end =System.currentTimeMillis();
			System.out.println("建立连接耗时:\t"+(end-start)+" 毫秒");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
