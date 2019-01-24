package cn.zzw.server.core;
/**
 * 服务器的小脚本
 * 
 * 
 * @author zzw
 *
 */

public interface Servlet {
	void service(Request request,Response response);
//	void doGet(Request request,Response response);
//	void doPost(Request request,Response response);

}
