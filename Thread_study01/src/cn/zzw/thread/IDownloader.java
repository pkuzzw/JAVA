package cn.zzw.thread;



/**
 * 继承Thread类
 * 重写run()方法
 * 
 * @author zzw
 *
 */

public class IDownloader implements Runnable{
	private String url;//下载路径
	private String name;//存储名字

	public IDownloader(String url,String name) {
		this.url=url;
		this.name=name;
	}
	
	//重写run方法
	//在线程体中调用webDownloader
	@Override
	public void run() {
		WebDownloader wd=new WebDownloader();
		wd.download(url, name);
		System.out.println(this.name);
		
	}
	
	
	public static void main(String[] args) {
		IDownloader td1 = new IDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548309675&di=b7110a5eab5d4536a87959061a6bf339&imgtype=jpg&er=1&src=http%3A%2F%2Fsz.java.tedu.cn%2Fupload%2F20161024%2F20161024102541_164.jpg","java.jpg");
		IDownloader td2 = new IDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1547704893&di=b92ab8bdc195b7e4cf137c51662ccb62&src=http://img.mukewang.com/55702d760001eded04500332.jpg","java1.jpg");
		IDownloader td3 = new IDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1547704893&di=fcf1f7e89d24d10c8e2d22975d492e45&src=http://pic.51yuansu.com/pic3/cover/02/18/59/59af228eaa0bc_610.jpg","java2.jpg");
		
		//启动三个线程
		Thread t1=new Thread(td1);
		Thread t2=new Thread(td2);
		Thread t3=new Thread(td3);

		t1.start();
		t2.start();
		t3.start();

	}
	
	
	
	
	
	
	
}
