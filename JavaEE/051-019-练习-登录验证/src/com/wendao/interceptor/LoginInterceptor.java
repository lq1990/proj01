package com.wendao.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wendao.pojo.Users;

/**
 * 	在没有login之前，不能访问其他页面
 * @author china
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object fn) throws Exception {
		// 若请求的是login控制器，则直接放行
		if(req.getRequestURI().endsWith("login")) {
			// uri: /login/login
			return true;
		}
		
		// 否则，需要判断是否已经登录
		Object obj = req.getSession().getAttribute("users");
		if(obj != null) {
			return true; // 放行
		}
		
		resp.sendRedirect("/login/login.jsp");
		return false;
	}

}

















