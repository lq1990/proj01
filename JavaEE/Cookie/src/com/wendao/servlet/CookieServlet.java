package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie学习：
 * 	作用：解决了发送的不同请求的数据共享问题。
 * 	使用：创建、设置、存储
 * 		创建Cookie对象
 * 			Cookie c = new Cookie("mouse", "ipad");
 * 		设置Cookie：
 * 			设置有效期
 * 				c.setMaxAge(int seconds);
 * 			设置有效路径
 * 				c.setPath(String uri); // uri: URL中 port和？之间的部分
 * 
 * 		响应Cookie信息给 client，Cookie是存在请求行。
 * 			resp.addCookie(c);
 * 
 * 	获取：
 * 		Cookie[] cks = req.getCookies();
			if(cks != null) { // 注意要判断，否则空指针异常。
				for(Cookie c : cks) {
					String name = c.getName();
					String value = c.getValue();
					System.out.println(name+":"+value);
				}
			}
 * 
 * 
 * 	注意：
 * 		一个Cookie对象存储一条数据。多条数据，可以创建多个Cookie对象进行存储。
 * 		
 * 	特点：
 * 		浏览器端的数据存储技术。
 * 		存储的数据声明在server。
 * 		临时存储：存储在浏览器的运行内存中，当关闭浏览器时，Cookie没了。
 * 		定时存储：c.setMaxAge(1000) // second。存储在client的硬盘中。
 * 			在有效期内符合路径要求的请求都会附带该信息。
 * 		设置有效路径：
 * 			默认cookie信息存好后，每次请求都会附带，除非设置有效路径。
 * 			
 * 
 * @author china
 *
 */
public class CookieServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码格式
		req.setCharacterEncoding("utf-8");
		
		// 获取请求信息
		resp.setContentType("text/html;charset=utf-8");
		
		// 处理请求信息
		
		
		// 响应处理结果
			// 使用Cookie进行浏览器端的数据存储
				// create Cookie obj
				Cookie c = new Cookie("mouse", "ipad"); 
				Cookie c2 = new Cookie("key", "wendao"); 
				
				// set 有效期
					c2.setMaxAge(3*24*3600);// 单位：秒
				// set 有效路径，只在这个路径下才提供Cookie
					c2.setPath("/cookie/gc"); // 注意：debug时，有时需要清除浏览器之前的Cookie
				
				// 响应Cookie信息
				resp.addCookie(c); // 在resp中加上自定的Cookie，这样在后面的其它req中会带上Cookie: mouse=ipad; 
				resp.addCookie(c2);
				
			// 直接响应
			resp.getWriter().write("Cookie学习");
			// 请求转发
			// 重定向
		
		
		
		
	}
	
}









