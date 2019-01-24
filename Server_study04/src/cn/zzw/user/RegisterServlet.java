package cn.zzw.user;

import cn.zzw.server.core.Request;
import cn.zzw.server.core.Response;
import cn.zzw.server.core.Servlet;

public class RegisterServlet implements Servlet{

	@Override
	public void service(Request request, Response response) {
		//关注业务逻辑
		String uname=request.getParameter("uname");
		String[] favs=request.getParameterValues("favorite");
		response.print("<html>");
		response.print("<head>");
		response.println("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">");
		response.print("<title>");
		response.print("注册成功");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.println("你注册的信息为:\t"+uname);
		response.println("你喜欢的类型为:\t");		response.print("\r\n");
		for (String v : favs) {
			if (v.equals("0") ){
				response.println("萝莉型");
			}else if (v.equals("1")) {
				response.println("豪放型");
			}else if (v.equals("2")) {
				response.equals("经济节约型");
			}else if (v.equals("3")) {
				response.println("熟女型");
			}
		}
		response.print("</body>");
		response.print("</html>");

		
	}


}
