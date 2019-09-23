package com.wendao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 	通过@Controller （功能和@Component一样）把此类交个spring管理
 * @author china
 *
 */
@Controller
public class DemoController {
	
	/**
	 * 	url请求 /anno/demo时，跳转到 main.jsp
	 * @return 返回值会被自动视图解析
	 */
	@RequestMapping("demo")
	public String demo() {
		System.out.println("执行demo");
		return "main.jsp"; // 这是相对路径
	}
	
	@RequestMapping("demo1")
	public String demo1() {
		System.out.println("DemoController.demo1()");
		return "main1.jsp";
	}
	
}
