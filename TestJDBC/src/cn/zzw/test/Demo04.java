package cn.zzw.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *测试Prepared Statement的基本用法
 * 
 * @author zzw
 *
 */

public class Demo04 {
	public static void main(String[] args) {
		//加载驱动类
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet set=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("加载成功");
			//建立连接  连接对象内部其实包含了Socket连接   比较耗时 比较耗时  比较耗时 这是Connecion对象管理的一个要点
			//真正开发中 为了提高连接效率都会使用连接池
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC?useSSL=false", "root", "123");

			String sql="select * from students where Number>?";//?占位符
		    ps=conn.prepareStatement(sql);
			ps.setObject(1, "12");//把ID大于120的都查询
			set=ps.executeQuery();//结果集 ResultSet
			while(set.next()) {
				System.out.println("Number:"+set.getInt(1)+"\tName:"+set.getString(2)+"\tAge:"+set.getInt(4));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			//关闭数据遵循 Resultset->Statement->Connection
			if (null!=set) {
				try {
					set.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null!=ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null!=conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
	}
		
	}

}
