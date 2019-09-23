package com.wendao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DemoController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("DemoController.handleRequest()");
		
		// 会自动把 /main.jsp找到，具体main路径在springmvc中配置了prefix/suffix
		ModelAndView mav = new ModelAndView("main");
		return mav;
	}

}
