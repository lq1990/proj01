package com.wendao.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wendao.service.UsersService;

@Controller
public class UsersController {

	@Resource
	private UsersService usersServiceImpl;
	
	@RequestMapping("show")
	public String show(Model model) {
		// model是request作用域
		model.addAttribute("list", usersServiceImpl.show());
		
		return "index.jsp";
	}
	
}
