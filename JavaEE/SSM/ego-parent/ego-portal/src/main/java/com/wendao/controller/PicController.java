package com.wendao.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wendao.service.PicService;

@Controller
public class PicController {
	
	@Resource
	private PicService picServiceImpl;
	
	/**
	 *	
	 * @return
	 */
	@RequestMapping("/")
	public String welcome(Model model) {
		System.out.println("PicController.welcome()");
		
		model.addAttribute("list", picServiceImpl.show());
		
		return "/index.jsp";
	}
	
	

}
