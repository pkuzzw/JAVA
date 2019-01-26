package cn.zzw.test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


/**
 * 网络类加载器
 * 
 * 
 * 1 继承java.lang.ClassLoader
 * 2 首先检查请求的类型是否已经被加载,如果已经加载 直接返回
 * 3 委派父类进行加载,如果加载成功,直接返回父类加载的java.lang.Class实例,如果父类加载失败,自行加载,
 * 	 加载成功,返回java.lang.Class实例,加载失败,抛出异常给LoadClass(...), LoadClass()转抛异常,终止加载
 * 
 * 注意 被两个加载器加载的同一个类,JVM不认为是同一个类
 * 
 * 
 * @author zzw
 *
 */
public class NetSystemClassLoader extends java.lang.ClassLoader{
	//cn.zzw.test.User---> wwww.zzw.cn   /home/zzw/eclipse-workplace/TestJVM/cn/zzw/test/User
	private String rootUrl;
	public NetSystemClassLoader(String rootDir) {
		this.rootUrl=rootDir;
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

		String path=rootUrl+"/"+name.replace(".", "/")+".class";
		
		InputStream is=null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		try {
			URL url=new URL(path);
			
			
			
			is=url.openStream();
			
			
			
			byte[] buffer=new byte[1];
			int temp=0;
			while((temp=is.read(buffer))!=-1) {
				baos.write(buffer);
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
