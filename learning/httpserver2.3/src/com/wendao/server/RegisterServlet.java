package com.wendao.server;

/**
 * for register
 * @author china
 *
 */
public class RegisterServlet implements Servlet{

	@Override
	public void service(Request req, Response res) {
		StringBuilder content = new StringBuilder();
		content.append("注册成功");
		res.println(content.toString());
		
	}
	
}
