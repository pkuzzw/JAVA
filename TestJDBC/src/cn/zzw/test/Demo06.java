package cn.zzw.test;
/**
 * 测试事务的基本概念和用法
 */

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

public class Demo06 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		try {
			//加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("加载成功");
			//建立连接  连接对象内部其实包含了Socket连接   比较耗时 比较耗时  比较耗时 这是Connecion对象管理的一个要点
			//真正开发中 为了提高连接效率都会使用连接池
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC?useSSL=false", "root", "123");
			
			conn.setAutoCommit(false);//JDBC中默自动提交事务
			String sql="insert into students (Number,Name,Home,Age) VALUES (?,?,?,?)";//?占位符
		    ps=conn.prepareStatement(sql);
			ps.setObject(1, 121212);//把ID大于120的都查询
			ps.setObject(2, "zhenwei");//把ID大于120的都查询
			ps.setObject(3, "linshu");//把ID大于120的都查询
			ps.setObject(4, 31);//把ID大于120的都查询
			ps.execute();
			
			System.out.println("插入了一个数据");
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sql="insert into students (Number,Name,Home,Age) VALUES (?,?,?,?)";//?占位符
		    ps1=conn.prepareStatement(sql);
			ps1.setObject(1, 121213);//把ID大于120的都查询
			ps1.setObject(2, "minying");//把ID大于120的都查询
			ps1.setObject(3, "haizhu");//把ID大于120的都查询
			ps1.setObject(4, 28);//把ID大于120的都查询
			ps1.execute();
			System.out.println("又插入了一个数据");
			
			
			conn.commit();//现在提交
			
			
			
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		}catch(SQLException e) {
			try {
				System.out.println("准备回滚");
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			//关闭数据遵循 Resultset->Statement->Connection
			if (null!=ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null!=ps1) {
				try {
					ps1.close();
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
