package com.wendao.atcrowdfunding.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerStartupListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 将web应用名称（路径）保存到application范围中
		ServletContext app = sce.getServletContext();
		String path = app.getContextPath();
		app.setAttribute("APP_PATH", path);
		
		// path是 /项目名
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
