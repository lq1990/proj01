package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * 	问题：
 * 		一个用户的不同请求处理的数据共享？
 * 	解决：
 * 		使用session技术
 * 
 * 	原理：
 * 	
 * 	特点：
 * 		session存储在server
 * 		server进行创建
 * 		依赖Cookie技术
 * 		一次会话
 * 		默认存储时间是 30min（指：用户最后一次访问开始计时）
 * 
 * session使用：
 * 		创建、获取：
 * 		HttpSession hs = req.getSession(); 
			当没有session则创建session-创建Cookie-将Cookie信息响应，有则获取。内部封装好了。
			若请求中有session的标识符JSESSIONID，则返回其对应的session对象。
			若请求中没有JSESSIONID，则创建新的session对象，
 *    	  		 并将其JSESSIONID作为cookie数据存到浏览器内存中。
 *    		若session对象失效了，也会重新创建一个session对象，并将其JSESSIONID存在浏览器内存中 。
 *    
 * 		设置session存储时间：
 * 			hs.setMaxInactiveInterval(int seconds); // 设置的时间会重新计时，是从最后一次访问开始计时
 * 		设置session强制失效：
 * 			hs.invalidate();
 * 
 * 		往session中set get 数据。前确保session有效，失效了就强制重新登录。
 * 			hs.setAttribute(String name, Object value);
 * 			hs.getAttribute(String name) : Object
 * 			实现不同请求之间的数据共享。
 * 
 * 		注意：
 * 			JSESSIONID存在了浏览器的Cookie的临时存储空间中，浏览器关闭即失效。
 * 			重启server，client再请求，则 session id必然变。
 * 
 * 		使用session时机：
 * 			用户在登录web项目时，会将用户的个人信息存在session中，供该用户的其它请求使用。
 * 	
 * 		总结：
 * 			session解决了一个用户的不同请求的数据共享问题，
			只要 在 browser的JSESSIONID和server的session不失效情况下。
			用户的任意请求在处理时都能获取到同一个session对象。
		作用域：
			一次会话
			在JSESSIONID和SESSION对象不失效的情况下，整个项目内。
		
		问题：
			如何判断session是否失效？session失效处理？
				将用户请求中的Cookie中JSESSIONID和
				和
				后台获取到的SESSION对象的JSESSIONID进行比对，
				若一致，则session没有失效，否则失效。
				session失效后，需要重定向登录页面
			
	项目session-timeout可以修改：
		tomcat/conf/web.xml或单独项目下web.xml修改
			<session-config>
        		<session-timeout>30</session-timeout>
    		</session-config>
			
 * 
 * @author china
 *
 */
public class SessionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置req resp 编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 获取req
		String name="张三";
		// 处理req
			// 创建、获取session对象
			HttpSession hs = req.getSession(); 
				// 当没有session则创建session-创建Cookie-将Cookie信息响应，有则获取。内部封装好了。
			// 设置session的存储时间
//			hs.setMaxInactiveInterval(5); // second
			
			// 获取session id
			System.out.println("ss  :"+hs.getId());
			// 设置session强制失效，场景：用户关闭browser
//			hs.invalidate();
			
			// 往session中存储数据
			hs.setAttribute("name", name);
			
		
			
		
		// 响应
			// 直接响应
			resp.getWriter().write("session 学习");
			// 请求转发
			// 重定向
		
	}
}























