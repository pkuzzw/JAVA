package cn.zzw.basic;

import java.util.HashSet;
import java.util.Set;

public class SortSet {
	
	public static void injectionSort(int[] number) {
		// 第一个元素作为一部分，对后面的部分进行循环
		for (int j = 1; j < number.length; j++) {
			int tmp = number[j];
			int i = j-1;
			while (tmp < number[i]) {
				number[i + 1] = number[i];
				i--;
				if (i == -1)
					break;
			}
			number[i + 1] = tmp;
		}
	}
	public static void main(String args[])
	{
		Set<Short> s=new HashSet<Short>();
		for(Short i=0;i<100;i++)
		{
			s.add(i);
			s.remove(i-1);
			s.remove("123");
		}
		System.out.println(s.size());
		//匿名内部类覆盖hashCode()方法
		Object obj = new Object() {
			public int hashCode() {
				return 42;
			}
		};
		System.out.println(obj.hashCode());
		
		String str = null;
		System.out.println(str);

	}

}
