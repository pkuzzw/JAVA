package cn.zzw.user;

import cn.zzw.server.core.Request;
import cn.zzw.server.core.Response;
import cn.zzw.server.core.Servlet;

public class OthersServlet implements Servlet{

	@Override
	public void service(Request request, Response response) {
		// TODO Auto-generated method stub
		response.print("其他测试页面,你懂得");
	}


}
