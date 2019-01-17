package cn.zzw.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 模拟龟兔赛跑
 * @author zzw
 *
 */

public class CRacer implements Callable<Integer>{

	private static String winner;
	
	@Override
	public Integer call() throws Exception {
		//模拟休息
		int steps;
		for (steps = 1;  steps <= 100; steps++) {
			if (Thread.currentThread().getName().equals("兔兔0001")&& ((steps%50)==0)) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println(Thread.currentThread().getName()+"-->"+steps);
			boolean flag=gameOver(steps);
			if (flag) {
				break;
			}
		}
		return steps;
	}

	
	private boolean gameOver(int steps) {
		if (winner!=null) {//存在胜利者
			return true;
		}else {
			if (steps==100) {
				winner=Thread.currentThread().getName();
				System.out.println("Winner is \t"+winner);
				return true;
			}
		}
		
		
		return false;
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CRacer racer=new CRacer();
		//创建执行服务
		ExecutorService ser=Executors.newFixedThreadPool(2);
		//提交执行
		Future<Integer> result1=ser.submit(racer);
		Future<Integer> result2=ser.submit(racer);
		//获取结果
		Integer r1=result1.get();
		Integer r2=result2.get();
		System.out.println("r1=\t"+r1);
		System.out.println("r2=\t"+r2);
		
		
	}




}
