package cn.zzw.test;

public class test001 {
	public static void main(String[] args) {
		  FileLength test1=new FileLength("/home/zzw/eclipse-workspace/MyPro01/src/cn/zzw");
		   System.out.println(test1.getLength());
		   System.out.println("folderNumber="+test1.getFolderNumber());
		   System.out.println("filenumbers="+test1.getFilenumbers());
		   
	}

}
