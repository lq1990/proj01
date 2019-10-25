package com.wendao.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wendao.pojo.Users;
import com.wendao.service.UsersService;


/**
 * 	Controller是Spring的注解。
 * 	但因为SpringMVC是spring的子容器，
 * 	此类交给SpringMVC管理
 * @author china
 *
 */
@Controller
public class UsersController {

	@Resource
	private UsersService usersServiceImpl;
	
	@RequestMapping("login")
	public String login(Users users, HttpSession session) {
		
		Users user = usersServiceImpl.login(users);
		
		if(user != null) {
			session.setAttribute("user", user);
			
			return "redirect:/main.jsp";
		} else {
			return "redirect:/index.jsp";
		}
		
	}
	
}


