package server;

import java.util.HashMap;
import java.util.Map;

/**
 * 关于Servlet的上下文
 * 由于Map中value是obj，耗费，改进
 * @author china
 *
 */
public class ServletContext {
	// 为每个servlet起名
	// login -> com.wendao.server.demo03.LoginServlet
	
	private Map<String, String> servlet; // 此处的val为obj，耗费性能。使用反射。
	// val为String，节省空间，动态调用，使用的使用才new实例。方法请看WebApp
	// url -> Login
	// /log -> Login 多种映射可以访问Login页面
	// /login ->Login
	private Map<String, String> mapping;
	
	public ServletContext() {
		this.servlet = new HashMap<String, String>();
		this.mapping = new HashMap<String, String>();
		
	}
	
	public Map<String, String> getServlet() {
		return servlet;
	}
	public void setServlet(Map<String, String> servlet) {
		this.servlet = servlet;
	}
	public Map<String, String> getMapping() {
		return mapping;
	}
	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
	
}
