package cn.zzw.test;
/**
 * 测试JDBCUtil的使用
 * @author zzw
 *
 */

import java.sql.Connection;

public class Demo11 {
	public static void main(String[] args) {
		Connection conn=JDBCUtil.Connect("testJDBC", "root","123456");
		if(conn==null) {
			System.out.println("连接失败");
		}else {
			System.out.println("连接成功");
		}
		
		
		
		
		
	}


}
