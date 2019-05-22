package com.wendao.server.demo03;

import java.util.Map;

/**
 * 	当前问题：static{}中内容随着扩展代码而修改，应改进
 * @author china
 *
 */
public class WebApp {
	private static ServletContext context;
	
	static {
		// 静态初始化
		context = new ServletContext();
		
		Map<String, String> mapping = context.getMapping();
		mapping.put("/login", "login");
		mapping.put("/log", "login");
		mapping.put("/reg", "register");
		
		Map<String, String> servlet = context.getServlet();
		servlet.put("login", "com.wendao.server.demo03.LoginServlet"); 
		// 要加上 包路径 
		servlet.put("register", "com.wendao.server.demo03.RegisterServlet");
		
	}
	
	/** 
	 * 	由url 找到对应的Servlet
	 * @param url
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static Servlet getServlet(String url) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (null == url || ((url = url.trim()).equals(""))) {
			return null;
		}
		// 根据字符串（完整路径）创建对象
		String mapping = context.getMapping().get(url);
		String pkg = context.getServlet().get(mapping);
		Class<?> clz = Class.forName(pkg); // 获取Class对象
		Servlet serv = (Servlet)clz.newInstance(); // 实例。确保空构造存在
		return serv;
		
//		return context.getServlet().get(context.getMapping().get(url));
	}
}
