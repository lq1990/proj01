package com.wendao.user;

import com.wendao.server.core.Request;
import com.wendao.server.core.Response;
import com.wendao.server.core.Servlet;

/**
 * for register
 * 
 * @author china
 *
 */
public class RegisterServlet implements Servlet {

	@Override
	public void service(Request req, Response res) {
		String[] favs = req.getParams("fav");
		String uname = req.getParam("uname");
		uname = (uname.equals("") ? "无名氏" : uname);
		
		StringBuilder content = new StringBuilder();
		content.append("<!DOCTYPE html>" + "<html>" + "<head>"
				+ "<meta http-equiv=\"content-type\" content=\"text/html;charset=UTf-8\">" + "<title>注册成功</title>"
				+ "</head>" + "<body>" + "<h3>你好啊，" + uname + "。欢迎来到我的世界！注册成功！</h3>");

		content.append("您的爱好: ");
		if (null != favs) {
			for (String f : favs) {
				if (f.equals("0")) {
					content.append("跑步 ");
				} else if (f.equals("1")) {
					content.append("睡觉 ");
				} else if (f.equals("2")) {
					content.append("看书 ");
				}
				// 前端form中不直接用字符串，而是数，是为了减少占字节数
			}
		}
		content.append("</body>" + "</html>");
		res.println(content.toString());

	}

}
