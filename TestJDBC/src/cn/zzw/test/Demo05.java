package cn.zzw.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *批处理执行SQL语句
 *1 批处理时尽量使用Statement,不要用PreparedStatement,因为后者预编译空间有限
 *2 事务要设置为手动提交
 *3 
 * @author zzw
 *
 */

public class Demo05 {
	public static void main(String[] args) {
		//加载驱动类
		Connection conn=null;
		Statement statement=null;
		ResultSet set=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC?useSSL=false", "root", "123");
			conn.setAutoCommit(false);  //设为手动提交
			statement=conn.createStatement();
			long start =System.currentTimeMillis();
			for (int i = 1; i < 20000; i++) {
				statement.addBatch("insert into students (Number,Name,Home,Age) VALUES ("+i+",'a"+i+"','b"+i+"','"+i+"')");
//				System.out.println("insert into students (Number,Name,Home,Age) VALUES ("+i+",'a"+i+"','b"+i+"','"+i+"')");
			}
			statement.executeBatch();
			conn.commit();//提交事务
			long end=System.currentTimeMillis();
			System.out.println("插入两万条数据耗时:\t"+(end-start)+" 毫秒");
			
			
			
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
			if (null!=statement) {
				try {
					statement.close();
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
