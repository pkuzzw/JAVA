package cn.zzw.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 创建线程的第三种方式:使用Callable接口
 * 1 创建目标对象
 * 2 重写call()方法,可以抛出异常,可以由返回值
 * 3 使用的时候要借助服务以及进程池来进行操作
 * 4 使用完毕要关闭服务
 * 
 * @author zzw
 *
 */

public class CDownloader implements Callable<Boolean>{
	private String url;
	private String name;
	public  CDownloader(String url,String name) {
		// TODO Auto-generated constructor stub
		this.url=url;
		this.name=name;
	}

	@Override
	public Boolean call() throws Exception {
		WebDownloader wd=new WebDownloader();
		wd.download(url,name);
		System.out.println(name);
		return true;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CDownloader cd1 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548309675&di=b7110a5eab5d4536a87959061a6bf339&imgtype=jpg&er=1&src=http%3A%2F%2Fsz.java.tedu.cn%2Fupload%2F20161024%2F20161024102541_164.jpg","java.jpg");
		CDownloader cd2 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1547704893&di=b92ab8bdc195b7e4cf137c51662ccb62&src=http://img.mukewang.com/55702d760001eded04500332.jpg","java1.jpg");
		CDownloader cd3 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1547704893&di=fcf1f7e89d24d10c8e2d22975d492e45&src=http://pic.51yuansu.com/pic3/cover/02/18/59/59af228eaa0bc_610.jpg","java2.jpg");
	
		//使用要借助服务以及进程池
		ExecutorService service=Executors.newFixedThreadPool(3);
		//提交执行
		Future<Boolean> result1=service.submit(cd1);
		Future<Boolean> result2=service.submit(cd2);
		Future<Boolean> result3=service.submit(cd3);
		
		//获取结果
		boolean r1=result1.get();
		boolean r2=result2.get();
		boolean r3=result3.get();
		System.out.println("r1=\t"+r1);
		System.out.println("r2=\t"+r2);
		System.out.println("r3=\t"+r3);
		
		//关闭服务
		service.shutdownNow();
	}
	
	
	
	
	
	
	
	
}
