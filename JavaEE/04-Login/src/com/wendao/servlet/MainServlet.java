package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wendao.pojo.User;

/**
 * 	欢迎登陆的主页面
 * 	
 * @author china
 *
 */
public class MainServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求编码格式
		req.setCharacterEncoding("utf-8");
		
		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		
		// 获取请求信息
		// req.getParameter("uname") 拿不到uname，因为重定向不是一次req。解决：用Cookie,session
			// get data in session
			User u = (User)req.getSession().getAttribute("user");
			
		
		// 处理请求信息
		
		// 响应处理结果
		
		resp.getWriter().write(
				"<html>"
				+"<head>"
				+ "</head>"
				+ "<body>"
				+ "<h3>欢迎"
				+ u.getUname()
				+ "访问我的网站!</h3>"
				+ "访问次数："
				+ this.getServletContext().getAttribute("nums")
				+ "<hr/>"
				+ "<form action='show' method='get' >"
				+ "<input type='submit' value='查看个人信息' />"
				+ "</form>"
				+ "</body>"
				+ "</html>");
		
	}
	
}
















