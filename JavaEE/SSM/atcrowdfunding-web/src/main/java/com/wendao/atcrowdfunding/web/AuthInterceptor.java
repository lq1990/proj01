package com.wendao.atcrowdfunding.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wendao.atcrowdfunding.bean.Permission;
import com.wendao.atcrowdfunding.service.PermissionService;

public class AuthInterceptor extends HandlerInterceptorAdapter  {
	
	@Autowired
	private PermissionService permissionServiceImpl;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取用户的请求地址
		String uri = request.getRequestURI();
//		System.out.println("uri: "+uri);
		
		String path = request.getSession().getServletContext().getContextPath();
		
		// 判断当前路径是否需要进行权限验证
		// 查询所有需要验证的路径集合
		List<Permission> ps = permissionServiceImpl.queryAll();
		Set<String> uriSet = new HashSet<String>();
		for (Permission permission : ps) {
			if (permission.getUrl() != null && !"".equals(permission.getUrl())) {
				uriSet.add(path
						+ permission.getUrl());
			}
		}
		
		// uriSet中包含所有的 permission对应的url
		
		
		if (uriSet.contains(uri)) {
			// 权限验证
			// 判断当前用户是否拥有对应的权限
			Set<String> authUriSet = (Set<String>) request.getSession().getAttribute("authUriSet");
			// authUriSet 是当前用户拥有的uri
			if (authUriSet.contains(uri)) {
				
				return true;
			} else {
				response.sendRedirect(path+"/error");
				return false;
			}
			
		} else {
			return true;
		}
		
	}

}










