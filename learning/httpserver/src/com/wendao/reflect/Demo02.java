package com.wendao.reflect;

import com.wendao.server.demo03.Servlet;

/**
 * 创建实例 调用空构造
 * @author china
 *
 */
public class Demo02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz = Class.forName("com.wendao.server.demo03.LoginServlet");
		// 调用空构造，应确保空构造存在
		Servlet ser = (Servlet)clz.newInstance();
		
		
	}
	
}
