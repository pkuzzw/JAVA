package cn.zzw.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;


/**
 *测试java.sql.date的使用
 * 
 * @author zzw
 *
 */

public class Demo07 {
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
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC?useSSL=false", "root", "123456");
			
			String sql="insert into t_user (username,pwd,date,lastlogin) VALUES (?,?,?,?) ;";//?占位符
		
			long start=System.currentTimeMillis();
			
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < 1000; i++) {
				ps.setObject(1, "高"+i);//把ID大于120的都查询
				ps.setObject(2, "12345");
				int rand=100000000+new Random().nextInt(100000000);
				Date date=new Date(System.currentTimeMillis()-rand);
				ps.setDate(3, date);
				Timestamp stamp=new Timestamp(System.currentTimeMillis()-rand);
				ps.setTimestamp(4, stamp);
				ps.execute();
			}
			long end=System.currentTimeMillis();
			
			System.out.println("数据插入完毕,耗时:\t"+(end-start)+"毫秒");
			
			
			
			
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
