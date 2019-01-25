package cn.zzw.test;

import java.io.FileReader;
import java.net.URL;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * 测试JAVA脚本引擎执行JavaScript代码
 * @author zzw
 *
 */
@SuppressWarnings("all")
public class Demo01 {
	public static void main(String[] args) {
		//第一步 获取JAVASCRIPT ENGINE 对象
		ScriptEngineManager sem=new ScriptEngineManager();
		ScriptEngine engine=sem.getEngineByName("javascript");
		
		//定义变量 存储到引擎上下文
		// java<---> Engine <---->Javascript
		engine.put("msg", "hello wolrd");
		String str="var user= {name:'zzw',age:18,schools:['暨南大学','北京大学']};";
		str+="print(user.name);";
		
		//执行脚本
		
		try {
			engine.eval(str);
			engine.eval("msg='hello a masg';");  //通过js修改了msg
			//通过java在读取msg的值 发现值已经被改变
			System.out.println(engine.get("msg"));
			System.out.println("---------------------------------");
			
			//定义函数
			engine.eval("function add(a,b){var sum=a+b;return sum;}");
			//执行js函数
			Invocable jsInvocable=(Invocable)engine;
			Object result1=jsInvocable.invokeFunction("add", new Object[]{13,20});
			System.out.println("result1=:\t"+result1);
			
			
			//导入其他的java包,使用其他的java类
			//var list=Arrays.list["北京大学","清华大学"];
			String jString="var list=java.util.Arrays.asList([\"北京大学\",\"清华大学\"]);";
			engine.eval(jString);
			
			System.out.println(engine.get("list"));
			
			//执行一个js文件(将a.js置于项目的src下即可
			URL url2=Demo01.class.getClassLoader().getResource("a.js");
			FileReader fr=new FileReader(url2.getPath());
			engine.eval(fr);
			fr.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
