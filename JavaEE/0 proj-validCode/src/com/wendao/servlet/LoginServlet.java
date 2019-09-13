package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wendao.pojo.Users;
import com.wendao.service.UsersService;
import com.wendao.service.impl.UsersServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	UsersService us;

	@Override
	public void init() throws ServletException {

		ApplicationContext ac = 
				WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		us = ac.getBean("usersService", UsersServiceImpl.class);
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// get
		String codeInp = req.getParameter("code");
		String codeSession = req.getSession().getAttribute("code").toString();

		if(codeInp != null && codeInp.equals(codeSession)) {
			// 验证码成功
			Users u = new Users();
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			u.setUsername(username);
			u.setPassword(password);
			Users user = us.login(u);
			
			if(user != null) { // 有这个用户
				resp.sendRedirect("/validate/main.jsp");
				return;
			} else {
				req.setAttribute("error", "用户不存在或密码错误");
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				return;
			}
			
		} else {
			// 验证码 失败
			req.setAttribute("error", "验证码不匹配");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		
		
	}

}











