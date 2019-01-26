package cn.zzw.test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 加载文件系统中解密后class文件
 * @author zzw
 *
 */

public class DecryptClassLoader extends java.lang.ClassLoader{
	//cn.zzw.test.User---> /home/zzw/eclipse-workplace/TestJVM/cn/zzw/test/User
	private String rootDir;
	public DecryptClassLoader(String rootDir) {
		this.rootDir=rootDir;
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c=findLoadedClass(name);
		//查询是否已经加载
		if (null!=c) {
			//已经被加载
			return c;
		}else {
			//未被加载,委派父类加载
			ClassLoader parent=this.getParent();
			try {
				c=parent.loadClass(name);  //委派
			} catch (Exception e) {
//				e.printStackTrace();
			}
			
			
			
			if (null!=c) {//父类加载成功
				return c;
			}else {
				//自行加载
				byte[] classData=getClassData(name);
				if (classData==null) {
					throw new ClassNotFoundException();
				}else {
					c=defineClass(classData, 0, classData.length);
				}
			}
			
			
		}
		
		
		
		return c;
		
	}
	
	private byte[] getClassData(String name) { //	//cn.zzw.test.User---> /home/zzw/eclipse-workplace/TestJVM/cn/zzw/test/User

		String path=rootDir+"/"+name.replace(".", "/")+".class";
		
		InputStream is=null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		try {
			is=new FileInputStream(path);
			int temp=-1;
			while((temp=is.read())!=-1) {
				baos.write(temp^0xff);
			}
			baos.flush();
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if (null!=is) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			try {
				if (baos!=null) {
					baos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}
}
