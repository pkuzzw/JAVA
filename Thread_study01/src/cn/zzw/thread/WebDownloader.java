package cn.zzw.thread;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * 下载图片
 * @author zzw
 *
 */

public class WebDownloader {
	/**
	 * 下载工具
	 * @param url
	 * @param name
	 */
	public void download(String url, String name) {
		try {
			FileUtils.copyURLToFile(new URL(url),new File(name));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("不合法的路径");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("图片下载失败");
			e.printStackTrace();
		}
	}

}
