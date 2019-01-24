package cn.zzw.server;
/**
 *<servlet-name>login</servlet-name>
 *<servlet-class>cn.zzw.server.basic.servlet.LoginServlet</servlet-class>
 *
 * @author zzw
 *
 */
public class Entity {
	private String name;
	private String clz;
	public Entity() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClz() {
		return clz;
	}
	public void setClz(String clz) {
		this.clz = clz;
	}
	public String toString() {
		return "name:"+name+"\tclass:"+clz;
	}

	
}
