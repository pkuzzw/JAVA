package cn.zzw.testOrm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 * 测试ORM映射
 * 
 * 测试使用Object[]来封装一条记录
 * 使用List<Object[]> list封装多条记录
 * 
 * @author zzw
 *
 */

public class Demo01 {
	public static void main(String[] args) {
		Connection conn=JDBCUtil.Connect("sorm", "root","123456");
		PreparedStatement ps=null;
		ResultSet set=null;
		Object[] objects=null;
		List<Object[]> list=null;
		
		System.out.println("连接成功,开始查询");
		try {
			String sql="select * from emp where id>? ";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "0");
			set=ps.executeQuery();
			list=new ArrayList<Object[]>();
			while(set.next()) {
				objects=new Object[3];//封装了一条记录
				System.out.println("Name:"+set.getString("empName")+"\tSalary:"+set.getInt("salary")+"\tage:"+set.getInt("age"));
				objects[0]=set.getString("empName");
				objects[1]=set.getInt("salary");
				objects[2]=set.getInt("age");
				list.add(objects);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(set, ps, conn);
		}
		System.out.println(list.size());
		for (Object[] ob : list) {
			System.out.println("object0:\t"+ob[0]);
			System.out.println("object1:\t"+ob[1]);
			System.out.println("object2:\t"+ob[2]);
		}
		
		
	}

}
