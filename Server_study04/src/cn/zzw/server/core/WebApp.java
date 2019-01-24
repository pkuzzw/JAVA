package cn.zzw.server.core;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;



public class WebApp {
	private static WebContext webContext;
	static {
		try {
			//SAX解析
			//1 获取解析工厂
			SAXParserFactory factory=SAXParserFactory.newInstance();
			//2 从解析工厂获取解析器
			SAXParser parser=factory.newSAXParser();
			//3 编写文档处理器
			//4 加载文档Document注册处理器
			WebHandler handler=new WebHandler(); 
			//5 解析
			parser.parse(Thread.currentThread().getContextClassLoader().
					getResourceAsStream("web.xml"), handler);
			//6 获取数据
			webContext=new WebContext(handler.getEntities(), handler.getMappings());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("解析配置文件错误");
		}
	}
	
	/**
	 * 通过Url获取配置文件对应的Servlet
	 * @param url
	 * @return
	 */
	
	public static Servlet getServletFromUrl(String url) {
		//假设你输入了 /login
		String clzString=webContext.getClz("/"+url);
		Class clz;
		try {
			clz = Class.forName(clzString);
			Servlet servlet=(Servlet)clz.getConstructor().newInstance();
			return servlet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}
	

}
