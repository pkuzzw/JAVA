package cn.zzw.commons;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;


/**
 * 写出内容
 * @author zzw
 *
 */

public class CIOTest04 {
	public static void main(String[] args) throws IOException {
		File src=new File("b.txt");
		FileUtils.write(src,"学习write\n","UTF-8");
		FileUtils.writeStringToFile(src, "学习writeStringtoFile\n","UTF-8",true);
		FileUtils.writeByteArrayToFile(src, "学习ByteArraytoFile\n".getBytes("UTF-8"), true);
		
		//写出列表
		List<String> datas=new ArrayList<String>();
		datas.add("马云");
		datas.add("马化腾");
		datas.add("弼马温");
		
		FileUtils.writeLines(src, datas,"---",true);
		
	}

}
