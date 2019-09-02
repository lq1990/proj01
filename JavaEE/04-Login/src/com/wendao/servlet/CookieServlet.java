package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wendao.pojo.User;
import com.wendao.service.LoginService;
import com.wendao.service.impl.LoginServiceImpl;

/**
 *	 /ck
 *	专门做登录校验.
 *		判断请求中是否携带正确的Cookie信息，eg 对用户免登陆的记录
 *			若有则校验Cookie信息是否正确
 *				若校验正确，则直接响应主页面给用户
 *					为了实现多个req数据流转，使用session
 *				若校验错误，则响应登录页面给用户。
 *			若没有Cookie，直接转发给登录页面
 *
 *	
 * 
 * @author china
 *
 */
public class CookieServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req resp编码设置
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 获取、处理req
			// 获取Cookie信息
			Cookie[] cks = req.getCookies();
			if(cks != null) {
				// 遍历Cookie信息
				String uid = "";
				for(Cookie c : cks) {
					if("uid".equals(c.getName())) {
						uid = c.getValue();
					}
				}
				
				// 校验uid是否存在
				if("".equals(uid)) { // uid不在Cookie
					// 转发
					req.getRequestDispatcher("page").forward(req, resp);
					return;
					
				} else { // uid 在Cookie
					// 校验uid用户信息
					LoginService ls = new LoginServiceImpl();
					User u = ls.checkUidService(uid); // check
					if(u != null) { // 在db中有uid
						// 将用户数据存储到session中，实现多个req数据交流
						req.getSession().setAttribute("user", u);
						
						// 网页计数器自增
						ServletContext sc = this.getServletContext();
						if(sc.getAttribute("nums") != null) {
							int nums = (int) sc.getAttribute("nums");
							nums++;
							sc.setAttribute("nums", nums);
						} else {
							sc.setAttribute("nums", 1);
						}
						
						// 重定向
						resp.sendRedirect("/login/main");
						return;
					} else { // 在db中没有uid
						req.getRequestDispatcher("page").forward(req, resp);
						return;
					}
					
				}
				
				
			} else {
				// no Cookie
				
				// 响应给client
					// 直接响应
					// 请求转发
					req.getRequestDispatcher("page").forward(req, resp);
					return;
					// 重定向
			}
		
		
		
	}
	
}




















