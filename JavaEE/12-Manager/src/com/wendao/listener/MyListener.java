package com.wendao.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * 	当前使用监听器，借助session app实现统计在线人数，
 * 	问题：
 * 		当用户关闭浏览器时，server端的session仍然没被销毁，server并不会及时知道用户已经退了。
 * 
 * @author china
 *
 */
public class MyListener 
	implements HttpSessionListener, 
	ServletContextListener {

	// session被创建时，意味着有新用户，++count
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// get app
		ServletContext sc = se.getSession().getServletContext();
		
		// get count, ++
		int count = (int) sc.getAttribute("count");
		count++;
		sc.setAttribute("count", count);
		System.out.println("有人登录，count:"+count);
	}

	// session被销毁时，意味着用户退出，--count
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("MyListener.sessionDestroyed()");
		
		// get app
		ServletContext sc = se.getSession().getServletContext();
		
		// set
		int count = (int) sc.getAttribute("count");
		count--;
		sc.setAttribute("count", count);
		System.out.println("有人退出，count:"+count);
		
	}


	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	// application对象初始化
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// get app
		ServletContext sc = sce.getServletContext();
		
		// set
		sc.setAttribute("count", 0);
		
		
	}

}











