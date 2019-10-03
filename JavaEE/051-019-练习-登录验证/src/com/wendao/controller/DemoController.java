package com.wendao.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wendao.pojo.Users;

/**
 * 	因为拦截器不能拦截 jsp，将main.jsp放到 page/
 * 	
 * @author china
 *
 */
@Controller
public class DemoController {

	/**
	 * 	restful风格
	 * 	可以解决：当page/ 中有多个jsp页面时，根据url中名称的不同 找到不同的jsp
	 * @return
	 */
	@RequestMapping("{page}")
	public String main(@PathVariable String page) {
		System.out.println("DemoController.main(), restful风格");
		
		return page; // 因为配置了视图解析器，等效于："/WEB-INF/page/" +page+ ".jsp"
	}
	
	@RequestMapping("login")
	public String login(Users users, HttpSession session) {
		if(users.getUsername() != null && users.getPassword() != null && users.getUsername().equals("admin") && users.getPassword().equals("123")) {
			session.setAttribute("users", users);
			
			return "main"; // 会走自定义视图解析器，若加 forward|redirect:/main 则代表走控制器
		} else {
			
			return "redirect:/login.jsp";
		}
		
	}
	
	
}









