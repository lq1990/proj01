package com.wendao.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wendao.pojo.Menu;
import com.wendao.pojo.Users;

@Controller
public class MenuController {
	
	/**
	 * 	ResponseBody注解：使得不跳转，而是以流的方式输出
	 * @param session
	 * @return
	 */
	@RequestMapping("getMenu")
	@ResponseBody
	public List<Menu> showMenu(HttpSession session){
		
		Users u = (Users) session.getAttribute("user");
		
		return u.getMenus();
	}
}
