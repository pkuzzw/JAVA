package cn.zzw.basic;

import javax.management.Query;

public class TestSort {
	public static void swap(int a,int b) {
		int temp=a;
		a=b;
		b=temp;
	}
	public static String change(String str) {
		str="hello,world";
		return str;
	}
	public static int binarySearch(int[] number, int key) {
		int low=0;
		int high=number.length-1;
		int middle=0;
		if (key< number[low] || key > number[high] || low>high) {
			return -1;
		}
		while(low<high) {
			middle=(low+high)/2;
			if (key>number[middle]) {
				low=middle+1;			
			}else if (key<number[middle]) {
				high=middle-1;
			}else {
				return middle;
			}
		}
		return -1;//最后仍然没找到,返回-1
		
		
	}
	public static void bubbleSort(int[] number) {
		//冒泡排序
		//双层循环 外层循环i 从0到length
		//双层循环 内层循环j 从0到n-1-i
		//        if a[i]>a[i+1] swap
		int temp;
		for (int i = 0; i < number.length; i++) {
			for (int j = 0; j < number.length-i-1; j++) {
				if (number[j]>number[j+1]) {
					temp=number[j];
					number[j]=number[j+1];
					number[j+1]=temp;					
				}
				
			}
		}		
	}
	
	public static void injectionSort(int[] number) {
		//选择排序
		int temp,j;
		for (int i = 1; i < number.length; i++) {
			//从当前位置开始向前查找插入位置
			//如果a[i]<a[i-1]则a[i-1]顺序往后排,直到找到插入位置将temp插入到位置
			//注意判断是否到达a[0]
			j=i;
			temp=number[i];
			while(temp<number[j-1]) {
				number[j]=number[j-1];
				j--;
				if (j==0) {
					//已经查到第一个元素,跳出循环
					break;
				}				
			}
			number[j]=temp;
		}
	}
	/**
	 * 希尔排序,也称为缩减增量排序,每次以h为步长进行插入排序
	 * 开始先生成步长 利用h=3*h+1
	 * 然后在对以h为步长的数组进行排序
	 * @param number
	 */
	public static void shellSort(int[] number) {
		int h=0;
		while(h<number.length) {
			//生成初始增量
			h=h*3+1;
		}
		while( h>=1) {
			for (int i = h; i < number.length; i++) {
				int j=i-h;
				int temp=number[i];
				while(j>=0 && number[j]>temp) {
					number[j+h]=number[j];
					j=j-h;
				}
				number[j+h]=temp;
			}//for
			h=(h-1)/3;
		}//while
	}
	/**
	 * 使用递归的二分查找
	 *title:recursionBinarySearch
	 *@param arr 有序数组
	 *@param key 待查找关键字
	 *@return 找到的位置
	 */
	public static int recursionBinarySearch(int[] arr,int key,int low,int high){
		
		if(key < arr[low] || key > arr[high] || low > high){
			return -1;				
		}
		
		int middle = (low + high) / 2;			//初始中间位置
		if(arr[middle] > key){
			//比关键字大则关键字在左区域
			return recursionBinarySearch(arr, key, low, middle - 1);
		}else if(arr[middle] < key){
			//比关键字小则关键字在右区域
			return recursionBinarySearch(arr, key, middle + 1, high);
		}else {
			return middle;
		}
	}
	/**
	 * 快速排序
	 * 在要排的数（比如数组A）中选择一个中心值key（比如A[0]），通过一趟排序将数组A分成两部分，其中以key为中心，key右边都比key大，key左边的都key小，然后对这两部分分别重复这个过程，直到整个有序。
        整个快排的过程就简化为了一趟排序的过程，然后递归调用就行了。
	 * @param number
	 */
	public static void quicksort(int[] a) {
		if(a.length>0) {
			quicksort(a,0,a.length-1);
		}
	}

	public static void quicksort(int[] number, int low, int high) {
		//找到递归出口的算法
		if (low>high) {
			return;
		}
		//存取位置
		int i=low;
		int j=high;
		
		//key
		int key=number[low];
		
		//完成一趟排序
		while(i<j) {
			//从右往左 找出第一个比key小的数字
			while(i<j && number[j]>key) {
				j--;
			}
			//从左往右,找出第一个比key大的数字
			while (i<j && number[i]<=key) {
				i++;
			}
			//交换
			if (i<j) {
				int temp=number[i];
				number[i]=number[j];
				number[j]=temp;
			}
		}//完成一趟排序 调整key的位置
		int temp=number[i];
		number[i]=number[low];
		number[low]=temp;
		
		quicksort(number,low,i-1);
		quicksort(number, i+1, high);		
	}
	
	
	
	public static void shownumber(int[] number) {
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i]+"  ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		int a=1;
		int b=2;
		System.out.println("a="+a+"\tb="+b);
		swap(a, b);
		System.out.println("a="+a+"\tb="+b);
		
		String string="nihao";
		System.out.println("string ="+string);
		change(string);
		System.out.println("string ="+string);
		System.out.println("------------Test Bubble Sort-----------");
		int[] number={1,22,9,900,289,12,32,1212,12919,2,3,12,9};
		System.out.println(number);
		shownumber(number);
//		injectionSort(number);
//		bubbleSort(number);
//		shellSort(number);
		quicksort(number);
//		QuickSort.quickSort(number);
		System.out.println("----after sort-----");
		System.out.println(number);
		shownumber(number);
		System.out.println(binarySearch(number, 112)+1);
		
		
		System.out.println("----------test singleton--------");
		SingletonDemo01 s1=SingletonDemo01.getInstance();
		s1.setName("饿汉式单例模式");
		System.out.println(s1.getName());
		SingletonDemo02 s2=SingletonDemo02.getInstance();
		s2.setName("懒汉式单例模式");
		System.out.println(s2.getName());
		
		
		
	}

}
