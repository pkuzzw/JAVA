package cn.zzw.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 分段读取,利用缓冲字节数组
 * @author zzw
 *
 */

public class IOTest04 {
	public static void main(String[] args) {
		File src=new File("abc.txt");
		InputStream is=null;
		int count=1;
		try {
			is=new FileInputStream(src);
			byte[] data= new byte[5];
			int len;
			while((len=is.read(data))!=-1) {
				//读取之后len代表实际个数
				//读取成功,最后一次不一定是读取到5个,有可能只是len个
				System.out.println("第"+(count++)+"次读取数据");
				//字节数组-->字符串 解码
				String str=new String(data, 0, len);
				System.out.println(str);
				for (int i = 0; i < len; i++) {
					System.out.println("字符编码:"+data[i]+"\t字符:"+(char)data[i]);
				}
				System.out.println("\n\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is!=null) {
				try {
					is.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

}
