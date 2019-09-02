package com.wendao.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * 	监听器的使用：
 * 		作用：
 * 			监听作用域对象request, session, application 的创建、销毁和内容的改变
 * 		使用：
 * 			I. 创建一个实现了指定接口的java类
 * 			 1. 监听request
 * 				监听 ServletRequestListener
 * 					监听request的创建、销毁
 * 					注意：
 * 						形参可以获取监听的request对象
 * 						sre.getServletRequest()
 * 				监听 ServletRequestAttributeListener
 * 					监听request attr的增删改
 * 					注意：
 * 						形参可以获取被监听的数据
 * 						srae.getName(), srae.getValue()					
 * 
 * 			  2. 监听session
 * 				监听 HttpSessionListener
 * 					监听session的创建和销毁
 * 					注意：形参可以获取被监听的session对象
 * 						se.getSession()
 * 				
 * 				HttpSessionAttributeListener
 * 					监听session attr的变更
 * 					注意：形参可以获取被监听的数据
 * 						event.getName(), event.getValue()
 * 
 * 			  3. 监听application
 * 				ServletContextListener 监听application的
 * 					初始化 server启动
 * 					销毁     server关闭
 * 					注意：
 * 						形参可以获取当前application对象 sce.getServletContext()
 * 				ServletContextAttributeListener 监听application attr的增删改
 * 					注意：
 * 						形参可以获取当前监听的数据, event.getName(), event.getValue()
 * 
 * 				
 * 
 * 			II. 在web.xml中配置
 * 			  <listener>
			  	<listener-class>com.wendao.listener.MyListener</listener-class>
			  </listener>	
 * 
 * 			III 案例
 * 				统计当前在线人数
 * 				统计网页浏览器次数
 * 
 * 
 * @author china
 *
 */
public class MyListener 
	implements ServletRequestListener, ServletRequestAttributeListener, 
	HttpSessionListener, HttpSessionAttributeListener,
	ServletContextListener, ServletContextAttributeListener {

	// request对象销毁的 监听
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("MyListener.requestDestroyed() 我被销毁");
		
	}

	// request对象创建的 监听
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("MyListener.requestInitialized() 创建");
		
		
		
	}

	// request中attr的增加
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("request中增加了一条数据 "
				+srae.getName()+":"+srae.getValue());
		
	}

	// request中attr的remove
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("request中移除了一条数据");
		
	}

	// request中attr的修改
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("request中修改了一条数据 "+srae.getName()+":"+srae.getValue());
		
		
	}

	/* ------------------- HttpSession ---------------------------------- */
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("MyListener.attributeAdded()"
				+event.getName()+":"+event.getValue());
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	// 监听session的创建
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("MyListener.sessionCreated() 创建");
		
	}

	// 监听session的销毁
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("MyListener.sessionDestroyed() 销毁");
	}

	
	/* ===================== ServletContext =================================== */
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("MyListener.attributeAdded() "
				+event.getName()+":"+event.getValue());
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("MyListener.contextDestroyed() 销毁");
//		当server关闭时，销毁applic
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("MyListener.contextInitialized() 初始化");
//		当server启动时 就初始化applic
		
	}

}
































