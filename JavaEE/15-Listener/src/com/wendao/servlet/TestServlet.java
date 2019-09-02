package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ts")
public class TestServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req。需求：当增删改attr时 触发事件
		req.setAttribute("str", "监听器学习");
		req.setAttribute("str2", "监听器学习2");
		
		HttpSession hs = req.getSession();
		hs.setAttribute("s1", "a session");
		hs.invalidate();
		
		this.getServletContext().setAttribute("sc1", "this is servlet context");
		
		// resp
		resp.getWriter().write("this is listener...");
		
	}

	
}
