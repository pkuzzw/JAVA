package cn.zzw.chat05;

import java.io.Closeable;

/**
 * 聊天室工具类
 * @author zzw
 *
 */

public class ChatUtils {
	/**
	 * 释放资源
	 */
	public static void close(Closeable...targets) {
		for (Closeable target : targets) {
			try {
				if (target!=null) {
					target.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
