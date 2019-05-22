package com.wendao.server.demo02;

import java.util.HashMap;
import java.util.Map;

/**
 * 关于Servlet的上下文
 * @author china
 *
 */
public class ServletContext {
	// 为每个servlet起名
	// login -> LoginServlet
	
	private Map<String, Servlet> servlet; // 此处的val为obj，耗费性能
	// url -> Login
	// /log -> Login 多种映射可以访问Login页面
	// /login ->Login
	private Map<String, String> mapping;
	
	public ServletContext() {
		this.servlet = new HashMap<String, Servlet>();
		this.mapping = new HashMap<String, String>();
		
	}
	
	public Map<String, Servlet> getServlet() {
		return servlet;
	}
	public void setServlet(Map<String, Servlet> servlet) {
		this.servlet = servlet;
	}
	public Map<String, String> getMapping() {
		return mapping;
	}
	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
	
}
