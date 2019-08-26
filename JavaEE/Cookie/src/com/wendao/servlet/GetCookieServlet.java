package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置req res编码格式
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 获取、处理req
			// 获取Cookie信息
			Cookie[] cks = req.getCookies();
			if(cks != null) {
				for(Cookie c : cks) {
					String name = c.getName();
					String value = c.getValue();
					System.out.println(name+":"+value);
				}
			}
			// 获取用户数据
		
		// 响应res
			// 直接响应
			// 请求转发
			// 重定向
		
		
	}
}
