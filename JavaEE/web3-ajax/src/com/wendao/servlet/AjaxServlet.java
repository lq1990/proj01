package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	web2.5 使用web.xml 配置
 *  web3.0 使用注解
 * @author china
 *
 */

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// encoding of req,resp
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// get req, process req
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		
		// resp
		resp.getWriter().write("Web3.0, 来自于AjaxServlet.jsp  "
				+uname+":"+pwd+":"+req.getMethod());

		
	}
}



















