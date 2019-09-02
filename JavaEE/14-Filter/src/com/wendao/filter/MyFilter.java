package com.wendao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 	过滤器的使用：
 * 		作用：
 * 			对server接受的请求资源 和 响应给浏览器的资源 进行管理
 * 		使用：
 * 			创建一个实现了Filter接口的普通java类。
 * 			重写接口的方法：
 * 				init() 服务器启动即执行，资源初始化
 * 
 * 				doFilter() 拦截请求的方法，在此方法中可以对资源实现管理
 * 					注意：需要手动对请求进行放行. chain.doFilter(request, response)
 * 
 * 				destroy() 服务器关闭时 执行。
 * 
 * 			在web.xml配置，或者在java文件中用注解 @WebFilter()
 * 				  <filter>
				  	<filter-name>myFilter</filter-name>
				  	<filter-class>com.wendao.filter.MyFilter</filter-class>
				  </filter>
				  <filter-mapping>
				  	<filter-name>myFilter</filter-name>
				  	<url-pattern>/*</url-pattern>
				  </filter-mapping>
				  
				  注意：
				  	/* 会拦截所有的请求
				  	*.do 拦截后缀是 .do
				  	test.do 拦截特定的请求，针对某个servlet的请求进行拦截，保护特定的servlet
 * 
 * 		过滤器的声明周期：
 * 			服务器启动 到 服务器关闭。
 * 		
 * 		总结：
 * 			过滤器程序员声明和配置，server根据请求中的uri信息调用。
 * 		执行：
 * 			浏览器发起请求到server，server接收到请求后，
 * 			根据uri在web.xml中找到对应的过滤器执行doFilter(), 处理后放行，
 * 			若还有其它过滤器，继续过滤处理再放行，
 * 
 * 			过滤器之后，servlet执行后，
 * 
 * 			回到过滤器的doFilter()
 * 
 * 			因此：过滤器即过滤req，也过滤resp
 * 
 * 		应用场景：
 * 			统一编码格式设置
 * 			session管理，过滤器中判断session是否失效，一旦失效让用户重新登录
 * 			权限管理
 * 			资源管理（统一水印，和谐词汇）
 * 			
 * 
 * 
 * 
 * 
 * @author china
 *
 */
@WebFilter("/*")
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("MyFilter.destroy() 销毁");
		
	}

	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilter.doFilter() 执行");
		
		// set encoding
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// session管理
		HttpSession hs = ((HttpServletRequest)request).getSession();
		if(hs.getAttribute("user") == null) {
			// 当session失效时，重定向到 登录页面
			((HttpServletResponse)response).sendRedirect("/filter/login.jsp");
		} else {
			
		// 放行给servlet去执行。执行完，还要回来
			chain.doFilter(request, response);
			// 此时response是经过servlet处理过的了
			
		}
			
			System.out.println("MyFilter.doFilter() 执行2");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		 System.out.println("MyFilter.init() 初始化");
		 
		 
	}

	
	
	
}












