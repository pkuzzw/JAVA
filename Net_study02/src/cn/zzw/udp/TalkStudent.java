package cn.zzw.udp;
/**
 * 加入多线程,实现双向交流,模拟在线咨询
 * @author zzw
 *
 */

public class TalkStudent {
	public static void main(String[] args) {
		new Thread(new TalkSend(7777, "localhost", 9999)).start();//学生发送
		
		new Thread(new TalkReceive("老师",8888)).start();//学生接收

		
		
	}

}
