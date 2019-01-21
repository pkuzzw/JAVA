package cn.zzw.udp;
/**
 * 加入多线程,实现双向交流,模拟在线咨询
 * @author zzw
 *
 */

public class TalkTeacher {
	public static void main(String[] args) {
		new Thread(new TalkReceive("学生",9999)).start();//老师接收
		
		new Thread(new TalkSend(7776, "localhost", 8888)).start();//学生发送

	}

}
