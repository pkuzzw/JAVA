package cn.zzw.others;


/**
 * 指令重排:
 * 代码的执行顺序与预期不一致
 * 
 * 目的:提高性能
 * @author zzw
 *
 */

public class HappenBefore {
	//变量1
	private static int a=0;
	//变量2
	private static boolean flag=false;
	
	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
		
			//线程1  更改数据
			Thread t1=new Thread(()-> {
				a=1;
				flag=true;			
			});
			//线程2  使用数据
			Thread t2=new Thread(()-> {
				if (flag) {
					a*=1;			
					System.out.println("HappenBefore a=\t"+a);
				}
				if (a==0) {
					System.out.println("HappenBefore a=\t"+a);
				}
			});
			t1.start();
			t2.start();
			
			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				t2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
		

}
