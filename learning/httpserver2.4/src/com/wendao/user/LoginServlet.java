package com.wendao.user;

import com.wendao.server.core.Request;
import com.wendao.server.core.Response;
import com.wendao.server.core.Servlet;

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
		String uname = req.getParam("uname");
		uname = (uname.equals("") ? "无名氏" : uname);
		content.append("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta http-equiv=\"content-type\" content=\"text/html;charset=UTf-8\">"
				+ 	"<title>第一个小脚本</title>"
				+ "</head>"
				+ "<body>"
				+ 	"<h3>你好啊，"
				+ uname
				+ "。欢迎来到我的世界！</h3>"
				+ "</body>"
				+ "</html>");
		res.println(content.toString());
		
	}
	
}
