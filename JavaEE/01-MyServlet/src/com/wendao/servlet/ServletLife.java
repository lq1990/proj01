package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class ServletLife extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		// init（）执行只在class第一次被加载到内存时。 
		System.out.println("servlet初始化完成");
		
	}
	
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// service方法是：真正处理请求的方法
		res.getWriter().write("servlet life");
		System.out.println("servlet life");
		
	}
	 
	@Override
	public void destroy() {
		// 在 Servers面板，右键tomcat stop
		System.out.println("我被销毁了");
	}
	
}
