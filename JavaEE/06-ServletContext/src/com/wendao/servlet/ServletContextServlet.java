package com.wendao.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	使用：
 * 		获取ServletContext对象，三种方式
 * 			ServletContext sc = this.getServletContext();
			ServletContext sc2 = this.getServletConfig().getServletContext();
			ServletContext sc3 = req.getSession().getServletContext();
 * 
 * 		使用ServletContext对象完后数据共享
 * 			sc.setAttribute(String name, Object value);
 * 			sc.getAttribute(String name) : Object;
 * 
 * 		注意：
 * 			不同的用户可以给ServletContext对象进行数据set get。
 * 			若获取的数据不存在，则返回null。
 * 
 * 	ServletContext其它功能：
 * 		1.获取项目中web.xml文件中的全局配置数据：
 * 			sc.getInitParameter(String name);
 * 			sc.getInitParameterNames(); 返回键名的枚举
 * 			配置方式：
 * 				一组<context-param>标签只能存储一组键值对数据，多组可以声明多个<context-param>
 * 			作用：
 * 				将静态数据和代码解耦。
 * 		2.获取项目根目录下的资源的绝对路径
 * 			String path = sc.getRealPath("/doc/1.txt");  // arg 为项目根目录的路径
 * 
 * 		3.获取webroot下的资源的流对象
 * 			InputStream is = sc.getResourceAsStream("/doc/1.txt");
 * 			注意：
 * 				此种方式只能获取项目跟目录下的资源流对象，class文件的流对象需用类加载器
 * 			
 * 			
 * 			
 * 
 * @author china
 *
 */
public class ServletContextServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// encoding
		
		// 获取ServletContext对象，3中方式等价
		ServletContext sc = this.getServletContext();
		ServletContext sc2 = this.getServletConfig().getServletContext();
		ServletContext sc3 = req.getSession().getServletContext();
		
		System.out.println(sc == sc2);
		System.out.println(sc == sc3);
		
		// 使用ServletContext完成数据共享
		sc.setAttribute("str", "ServletContext 学习");
		
		// 获取项目web.xml的全局配置数据
		String name = sc.getInitParameter("name");
		System.out.println("全局配置参数: "+name);
		
		// 获取项目根目录下的资源的绝对路径
		String path = sc.getRealPath("/doc/1.txt"); // WebRoot作为项目根目录
		System.out.println(path); // D:\APP\apache-tomcat-7.0.96\webapps\sc\doc\1.txt
		
		// 获取项目根目录下资源的流对象
		InputStream is = sc.getResourceAsStream("/doc/1.txt");
		
		
		
	}
}








