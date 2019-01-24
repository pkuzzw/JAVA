package cn.zzw.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
/**
 * 使用反射读取注解信息,模拟处理注解信息的流程
 * @author zzw
 *
 */

public class Demo03 {
	public static void main(String[] args) {
		try {
			Class clz=Class.forName("cn.zzw.annotation.Student");
			
			//获取所有的注解
			Annotation[] annotations=clz.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			
			//获得类指定注解的值
			System.out.println("--------------------1---------------------");
			StudentTable table=(StudentTable) clz.getAnnotation(StudentTable.class);
			System.out.println("table-name:\t"+table.value());
			
			//获得类的属性的注解
			Field field=clz.getDeclaredField("name");//这个name对应的是类的属性名,要通过属性名来找注解的
			StudentField studentField=field.getAnnotation(StudentField.class);
			System.out.println("columnName:\t"+studentField.columnName()+"\ntype:\t"+studentField.type()+"\nlength:\t"+studentField.length());
			
			field=clz.getDeclaredField("age");
		    studentField=field.getAnnotation(StudentField.class);
			System.out.println("columnName:\t"+studentField.columnName()+"\ntype:\t"+studentField.type()+"\nlength:\t"+studentField.length());
			
			field=clz.getDeclaredField("id");
		    studentField=field.getAnnotation(StudentField.class);
			System.out.println("columnName:\t"+studentField.columnName()+"\ntype:\t"+studentField.type()+"\nlength:\t"+studentField.length());
			
			
			//根据获得的字段信息,拼接处DDL语句,使用JDBC执行这个SQL 将数组存储到数据库中
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
