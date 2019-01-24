package cn.zzw.server;

public class LoginServlet implements Servlet{

	@Override
	public void service(Request request, Response response) {
		// TODO Auto-generated method stub
		response.print("<html>");
		response.print("<head>");
		response.print("<title>");
		response.print("第一个小脚本Servlet");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("\r\n----欢迎回来---\r\n"+request.getParameter("uname"));
		response.print("\r\n");
		response.print("</body>");
		response.print("</html>");
	}

}
