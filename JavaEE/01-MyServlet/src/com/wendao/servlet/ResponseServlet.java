package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	Resp对象学习
 * 	作用：
 * 		响应数据到浏览器的一个对象。
 * 	使用：
 * 		设置响应头：
 * 			resp.setHeader(name, value); // 在响应头中设置响应信息，同键会覆盖。
 * 			resp.addHeader(name, value); // 在响应头中添加响应信息，但是不会覆盖。
 * 
 * 		设置响应状态：
 * 			resp.sendError(code, msg);
 * 		设置响应实体：
 * 			resp.getWriter().write(str);
 *			配合设置编码格式：
 *			resp.setContentType("text/html;charset=utf-8");
 *
 *	总结：
 *		service请求处理代码流程：
 *			设置response编码格式
 *			获取request数据
 *			处理request数据
 *				数据库操作（MVC思想）
 *			响应response结果
 *
 *
 * 	
 * @author china
 *
 */
public class ResponseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取请求信息
			// 获取请求头
			// 获取请求行
			// 获取用户数据
		// 处理请求
		
		// 响应处理结果
			// 设置响应头
			resp.setHeader("mouse", "mouse0");
			resp.setHeader("mouse", "mouse1");
			resp.addHeader("mouse", "mouse2"); 
			/*
			 *  最终会有 
			 *  mouse: mouse1
				mouse: mouse2
			 */
			
			// 设置响应编码格式
//			resp.setHeader("Content-Type", "text/html;charset=utf-8"); or
			resp.setContentType("text/html;charset=utf-8");
			
			/*
			 * Content-Type: 
			 * 	text/html;charset=utf-8 
			 * 	text/xml;charset=utf-8 
			 * 	text/plain;charset=utf-8 普通文本，不被解析
			 * 
			 */
			
			// 设置响应状态码
//			resp.sendError(404, "this method is not supported.");
			
			// 设置响应实体
			resp.getWriter().write("this is resp。学习使我开心");
		
	}
	
	
}














