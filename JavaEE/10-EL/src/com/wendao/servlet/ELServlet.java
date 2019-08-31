package com.wendao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wendao.pojo.Address;
import com.wendao.pojo.User;

/**
 * 	问题：
 * 		servlet ----data----> jsp
 * 		在servlet进行请求处理后，使用作用域对象作为数据流转的载体。将数据流转给对应的jsp文件。
 * 		那么怎么在jsp中获取作用域中的数据呢？
 * 	使用：
 * 		传统方式：在jsp页面中使用java脚本段语句。
 * 		
 * 
 * 
 * @author china
 *
 */
@WebServlet("/es")
public class ELServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// encoding
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// req
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		System.out.println(uname+":"+pwd);
		
		// resp
			// 使用request作用域进行数据流转
				// 普通字符串
				req.setAttribute("str", "今天天气不错！");
				// 对象类型
				User u = new User(1, "刘岩", "movie", new Address("山东", "枣庄", "薛城"));
				req.setAttribute("user", u);
				// 集合类型
					// List
						List<String> list = new ArrayList<String>();
						list.add("张杰辉");
						list.add("管管");
						list.add("刘诗诗");
						req.setAttribute("list", list);
						
						List<User> listUser = new ArrayList<User>();
						listUser.add(new User(2, "anna", "singing", 
								new Address("sachsen", "hannvor", "abc")));
						req.setAttribute("listUser", listUser);
						
					// Map
						Map<String, String> map = new HashMap<String, String>();
						map.put("a", "bj");
						map.put("b", "sh");
						map.put("c", "sz");
						req.setAttribute("map", map);
						
						Map<String, User> mapUser = new HashMap<String, User>();
						mapUser.put("a1", new User(3, "明明", "怼人", 
								new Address("河北", "河北北", "北南")));
						req.setAttribute("mapUser", mapUser);
						
					// 空值判断
						req.setAttribute("s", "");
						req.setAttribute("s1", new User());
						req.setAttribute("s2", new ArrayList());
						req.setAttribute("s3", new HashMap());
						
				
						
			// 请求转发
			req.getRequestDispatcher("/el.jsp").forward(req, resp);
			return;
		
	}
	
}















