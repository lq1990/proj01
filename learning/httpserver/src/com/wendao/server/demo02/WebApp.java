package com.wendao.server.demo02;

import java.util.Map;

public class WebApp {
	private static ServletContext context;
	
	static {
		// 静态初始化
		context = new ServletContext();
		
		Map<String, String> mapping = context.getMapping();
		mapping.put("/login", "login");
		mapping.put("/log", "login");
		mapping.put("/reg", "register");
		
		Map<String, Servlet> servlet = context.getServlet();
		servlet.put("login", new LoginServlet());
		servlet.put("register", new RegisterServlet());
		
	}
	
	public static Servlet getServlet(String url) {
		if (null == url || ((url = url.trim()).equals(""))) {
			return null;
		}
		
		return context.getServlet().get(context.getMapping().get(url));
	}
}
