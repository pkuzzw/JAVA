package cn.zzw.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.cj.jdbc.Clob;




/**
 *测试CLOB 文本大对象的使用
 * 
 * 利用IO流对CLOB进行插入和读取
 * 
 * @author zzw
 *
 */

public class Demo09 {
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
		Reader r=null;
		try {
			//加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testJDBC?useSSL=false", "root", "123456");
			
//			ps=conn.prepareStatement("insert into t_user (username, myInfo) values (?,?)");
//			ps.setString(1, "小小");
			//将文本文件内容直接输入到数据库中
//			ps.setClob(2, new FileReader(new File("/home/zzw/Documents/test.txt"),Charset.defaultCharset()));
			
			//将程序中的字符串存入到数据库中
//			ps.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("asdasd".getBytes()))));
//			ps.executeUpdate();
			ps=conn.prepareStatement("select * from t_user where username=?");
			ps.setObject(1, "大大");
			ResultSet set=ps.executeQuery();
			while (set.next()) {
				System.out.println("username:\t"+set.getString(1)+"\nmyInfo:\t"+set.getClob(5));
				java.sql.Clob c=set.getClob(5);
				
				//读取Clob仍然是利用流进行读出
				r=c.getCharacterStream();
				int temp=0;
				while((temp=r.read())!=-1) {
					System.out.print((char)temp);
				}
				
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//关闭数据遵循 Resultset->Statement->Connection
			if (null!=r) {
				try {
					r.close();
				} catch (IOException e) {
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
