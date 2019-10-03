package com.wendao.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 	因为拦截器不能拦截 jsp，将main.jsp放到 page/
 * 	
 * @author china
 *
 */
@Controller
public class DemoController {

	/**
	 *  @RequestMapping(默认添加.do后缀)
	 * @return
	 */
	@RequestMapping("demo")
	public String demo() {
		System.out.println("DemoController.demo()");
		return "main";
	}
	
}









