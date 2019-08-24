package com.wendao.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.management.counter.Variability;

/**
 * request对象学习：
 * 	作用：request对象中封存了当前请求的所有请求信息
 * 	使用：
 * 		获取 请求头数据
 * 			req.getMethod() // 获取请求方法
 * 			req.getRequestURL()
 * 			req.getRequestURI()
 * 			req.getScheme() // 获取协议
 * 
 * 		获取 请求行数据
 * 			String val = req.getHeader("key eg User-Agent"); // 返回指定的请求头信息
 * 			Enumeration req.getHeaderNames(); // return keys of 头信息
 * 
 *		获取用户数据
 *			req.getParameter("uname"); // form表单中数据
 *			req.getParameterValues("key eg. fav"); // 键对应多个值时，取值，返回 String[]
 *			Enumeration req.getParameterNames(); // 键的枚举集合，不常用。因为键是程序员必须知道的
 *
 *		注意：
 *			若要获取的请求数据不存在，不会报错，返回null。
 *				所有注意空指针异常。
 *
 *
 * 	注意：
 * 		req对象由tomcat服务器创建，并作为实参传递给处理请求的servlet的service方法。
 * 
 * @author china
 *
 */
public class RequestServlet extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取请求头数据
			// 获取请求方式
			String method = req.getMethod();
			System.out.println(method);
			
			// 获取请求URL, URI
			StringBuffer url = req.getRequestURL();
			System.out.println(url); // http://localhost:8080/01-MyServlet/req
			String uri = req.getRequestURI(); 
			System.out.println(uri); // /01-MyServlet/req
			
			// 获取协议
			String protocol = req.getScheme();
			System.out.println(protocol);
		
		// 获取请求行数据
			// 获取指定的请求行信息
			String agent = req.getHeader("User-Agent");
			System.out.println(agent);
			
			// 获取所有的请求行的键的枚举
			System.out.println("-------------------------------\n请求行数据：");
			Enumeration keys = req.getHeaderNames();
			while(keys.hasMoreElements()) {
				String k = (String)keys.nextElement();
				String val = req.getHeader(k);
				
				System.out.println(k+": "+val);
				
			}
			
		// 获取用户数据。get post请求，都可以使用 req.getParameter()
		System.out.println("--------------------------------\n用户数据：");
			String uname = req.getParameter("uname");
			String pwd = req.getParameter("pwd");
			String fav = req.getParameter("fav"); // 只能获取第一次的fav，会漏掉其它值
			String[] favs = req.getParameterValues("fav"); // 正确获取
			
			System.out.println(uname+", "+pwd+", "+fav+", "+ Arrays.toString(favs));
			
			// 获取所有的用户请求数据的键的枚举集合
			Enumeration names = req.getParameterNames();
			System.out.println("names: ");
			while(names.hasMoreElements()) {
				System.out.println(names.nextElement());
			}
			
			
			// 乱码：post请求时 中文乱码。get请求目前可以。
			
			
		
		
	}
	
	
}




















