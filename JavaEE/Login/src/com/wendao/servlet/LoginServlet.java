package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wendao.pojo.User;
import com.wendao.service.LoginService;
import com.wendao.service.impl.LoginServiceImpl;

/**
 * 	req过来的数据 中文乱码问题：
 * 	方法：
 * 	1. 使用 uname = new String(uname.getBytes("iso8859-1"), "utf-8"); // req过来的中文乱码的解决。
 * 	2. 使用公共配置
 * 		get方式：
 * 			步骤1： req.setCharacterEncoding("utf-8");
 * 			步骤2：tomcat目录下/conf/server.xml 
 * 				<Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443"
			   useBodyEncodingForURI="true" />
 * 
 * 		post方式：
 * 			req.setCharacterEncoding("utf-8");
 * 
 * 	Servlet流程总结：
 * 		1. 浏览器发起请求到server
 * 		2. server接受browser的请求，进行解析，创建request对象存储数据
 * 		3. server调用对应的servlet进行请求处理，并将request对象作为实参传给servlet的方法
 * 		1-3是server帮我们做的。
 * 		4. servlet的方法执行进行请求处理
 * 			设置请求编码格式
 * 			设置响应编码格式
 * 			获取请求信息
 * 			处理请求信息
 * 				创建业务层对象 LoginService
 * 				调用业务层对象的方法	
 * 			响应处理结果
 * 		
 * 	数据 流转流程：
 * 		Browser --> server --> db
 * 		Browser <-- server <-- db
 * 
 * =================================================
 * 
 * 	请求转发学习：
 * 		作用：实现多个Servlet联动操作处理请求。避免代码冗余，Servlet职责更明确。
 * 	使用：
 * 		req.getRequestDispatcher("相对路径写servlet别名即可 or jsp").forward(req, resp);
 * 
 * 	特点：
 * 		一次请求，浏览器地址栏信息不改变。
 * 
 * 	注意：
 * 		请求转发后，直接return结束即可，要完成的工作有其它Servlet去做即可。
 * 
 * @author china
 *
 */
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求编码格式
		req.setCharacterEncoding("utf-8");
		
		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		
		// 获取请求信息
		String uname = req.getParameter("uname");
		// uname = new String(uname.getBytes("iso8859-1"), "utf-8"); // req过来的中文乱码的解决。
		
		String pwd = req.getParameter("pwd");
		System.out.println(uname+":"+pwd);
		
		// 处理请求信息
			// 获取业务层对象
			LoginService ls = new LoginServiceImpl();
			User u = ls.checkLoginService(uname, pwd); 
			// 把client传过来的url中uname pwd信息，进行check，当db中有uname pwd时，则从db拿到结果。
			System.out.println("find user from db: "+u);
			
		// 响应处理结果
		if(u != null) {
			resp.getWriter().write("欢迎"+uname+"，登录成功!");
			
		} else {
			// 在一个Servlet中太多代码，冗余。解决：使用多个Servlet联合，使用请求转发
			
//			String str = "";
//			str += 
//				"<html>" +
//					"<head>" +
//					"</head>" +
//					"<body>" +
//						"<form action='login' method='get' >" +
//							"用户名: <input type='text' name='uname' value='' /><br/>" +
//							"密码: <input type='password' name='pwd' value='' /><br/>" +
//							"<input type='submit' name='' value='登录' />" +
//						"</form>" +
//					"</body>" +
//				"</html>";
//			
//			resp.getWriter().write(str);
			
			// 因为req会流经多个Servlet，涉及到不同Servlet数据传递
			req.setAttribute("str", "用户名或密码错误"); // 设置后，将req传给page时，page能拿到这个数据。
			
			// 使用请求转发
			req.getRequestDispatcher("page").forward(req, resp); // 类似于fn使用
			// 						"要转到的别名, 在web.xml中配置了"
			return; // 转发后，直接return即可
			
		}
		
	}
}















