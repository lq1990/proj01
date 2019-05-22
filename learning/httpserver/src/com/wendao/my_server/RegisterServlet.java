package com.wendao.my_server;

/**
 * 
 * @author china
 *
 */
public class RegisterServlet extends Servlet {

	

	@Override
	public void doGet(Request req, Response res) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void doPost(Request req, Response res) throws Exception {
		res.println("<html><head><title>注册</title>");
		res.println("</head><body>");
		res.println("你好啊 " + req.getParam("uname") + ". Welcome to my world.");
		res.println("</body></html>");
	}

}
