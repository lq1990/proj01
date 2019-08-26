package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wendao.pojo.User;

public class ShowServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// set encoding
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// req, 访问session之前确保session有效
		HttpSession hs = req.getSession();
		if(hs.getAttribute("user") == null) {
			// 说明此时session失效了，重定向到 CookieServlet
			resp.sendRedirect("/login/ck");
			return;
		}
		
		User u = (User) hs.getAttribute("user");
		int uid = u.getUid();
		String uname = u.getUname();
		String pwd = u.getPwd();
		
		// resp
		resp.getWriter().write(
				"<html>"
				+ "<head>"
				+ "</head>"
				+ "<body>"
				+ "<table border='1px' cellspacing='0' style='font-size: 20px; '>"
				+ "<tr>"
				+ 	"<td>"
				+		"uid"
				+ 	"</td>"
				+ 	"<td>"
				+		 "uname"
				+ 	"</td>"
				+ 	"<td>"
				+		 "pwd"
				+ 	"</td>"
				+ "</tr>"
				
				+ "<tr>"
				+ 	"<td>"
				+		 uid
				+ 	"</td>"
				+ 	"<td>"
				+		 uname
				+ 	"</td>"
				+ 	"<td>"
				+		 pwd
				+ 	"</td>"
				+ "</tr>"
				
				+ "</table>"
				+ "</body>"
				+ "</html>");
		
	}
}












