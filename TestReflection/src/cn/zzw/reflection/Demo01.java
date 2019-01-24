package cn.zzw.reflection;
/**
 * 测试java.lang.Class对象的获取方式
 * @author zzw
 *
 */
@SuppressWarnings("all")
public class Demo01 {
	
	public static void main(String[] args) {
		String path="cn.zzw.javabean.User";
		
		try {
			Class clz=Class.forName(path);
			System.out.println(clz.hashCode());
			
			Class clz2=Class.forName(path);
			System.out.println(clz2.hashCode());
			
			
			String str=new String();
			clz=String.class;
			clz2=str.getClass();
			System.out.println(clz.hashCode());
			System.out.println(clz2.hashCode());
			
			int[] a=new int[10];
			int[][] b=new int[20][10];
			String[][] strings=new String[10][11];
			Class clz3=strings.getClass();
			clz=a.getClass();
			clz2=b.getClass();
			System.out.println("-----------------------------");
			System.out.println(clz.hashCode());
			System.out.println(clz2.hashCode());
			System.out.println(clz3.hashCode());
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
