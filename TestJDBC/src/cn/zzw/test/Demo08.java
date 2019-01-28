package cn.zzw.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 *测试时间处理(java.sql.Date, Time, Timestamp),取出指定时间段的数据
 * 
 * @author zzw
 *
 */

public class Demo08 {
	/**
	 * 将字符串代表的日期转为long数字(格式为:yyyy-MM-dd hh:mm:ss)
	 * @param dateStr
	 * @return
	 */
	public static long strToDate(String dateStr) {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return format.parse(dateStr).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet set=null;
		try {
			//加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC?useSSL=false", "root", "123456");
			ps=conn.prepareStatement("select * from t_user where lastlogin >? and lastlogin <?;");
			
			Date start=new Date(strToDate("2019-01-25 10:23:45"));
			Date end=new Date(strToDate("2019-01-28 10:23:45"));
			System.out.println("开始执行查询");
			ps.setObject(1, start);
			ps.setObject(2, end);
			set=ps.executeQuery();
			
			System.out.println("查询完毕,结果如下:");
			while(set.next()) {
				System.out.println("username:"+set.getString(1)+"\tpwd:"+set.getString(2)+"\tdate:"+set.getDate(3)+"\tlastlogin:"+set.getTimestamp(4));
			}
			
			
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		}catch(SQLException e) {
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
