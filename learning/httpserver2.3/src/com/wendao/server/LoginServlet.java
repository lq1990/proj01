package com.wendao.server;

/**
 * for login
 * @author china
 *
 */
public class LoginServlet implements Servlet{

	@Override
	public void service(Request req, Response res) {
		// 关注了内容
		StringBuilder content = new StringBuilder();
		content.append("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ 	"<title>第一个小脚本</title>"
				+ "</head>"
				+ "<body>"
				+ 	"<h3>你好啊，"
				+ req.getParam("uname")
				+ "。欢迎来到我的世界！</h3>"
				+ "</body>"
				+ "</html>");
		res.println(content.toString());
		
	}
	
}
