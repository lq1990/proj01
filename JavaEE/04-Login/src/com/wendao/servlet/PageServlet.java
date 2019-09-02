package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * for client:
 * 先输入 page，
 * 	有form会action 到login
 * 
 * 
 * @author china
 *
 */
public class PageServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		
		// 获取请求信息
		
		
		// 处理请求
		
		// login 转到 page时，有数据传过来。获取request作用域数据
		String str0 = (String)req.getAttribute("str");
		str0 = str0==null ? "" : str0;
		
		// 响应处理结果
		String str = "";
		str += 
			"<html>" +
				"<head>" +
				"</head>" +
				"<body>"
				+ "	<font size='20px' color='red'>"
				+ 	str0
				+ "</font>" +
					"<form action='login' method='get' >" +
						"用户名: <input type='text' name='uname' value='' /><br/>" +
						"密码: <input type='password' name='pwd' value='' /><br/>" +
						"<input type='submit' name='' value='登录' />" +
					"</form>" +
				"</body>" +
			"</html>";
		
		resp.getWriter().write(str);
		
	}
}










