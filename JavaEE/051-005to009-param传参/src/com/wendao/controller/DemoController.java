package com.wendao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wendao.pojo.Demo;
import com.wendao.pojo.People;

/**
 * 	通过@Controller （功能和@Component一样）把此类交个spring管理
 * 
 * 
 * 	表单数据submit后，若想取得parameter，在控制器类中方法中 传参.
 * 
 * 	字符集 在web.xml中配置filter
 * @author china
 *
 */
@Controller
public class DemoController {
	// 为了保证线程安全，controller类中不要加全局属性
	
	/**
	 * 	url请求 /anno/demo时，跳转到 main.jsp
	 * 
	 * 	
	 * 	参数：
	 * 		当参数是基本数据类型 和query参数同名时，url会被spring自动解析
	 * 		当参数是对象时，对象的属性会被自动注入，spring是知道对象的属性的
	 * 		原生servlet的参数也可以传
	 * 	
	 * 
	 * @return 返回值会被自动视图解析
	 */
	@RequestMapping("demo")
	public String demo(People p, String name, int age, HttpServletRequest req) {
		System.out.println("执行demo, "+p+", "+name+", "+age);
		req.setAttribute("demo666", "测试用");
		return "main.jsp"; // 这是相对路径
	}
	
	@RequestMapping("demo1")
	public String demo1() {
		System.out.println("DemoController.demo1()");
		return "main1.jsp";
	}
	
	
	// 强制参数，不能为null，否则报异常
	@RequestMapping("demo2")
	public String demo2(@RequestParam(required=true) String name) {
		
		return "main.jsp";
	}
	
	
	// 参数默认值
	@RequestMapping("page")
	public String page(@RequestParam(defaultValue="2") int pageSize, 
			@RequestParam(defaultValue="1") int pageNumber) {
		
		System.out.println("DemoController.page(), "+pageSize+", "+pageNumber);
		
		return "main.jsp";
	}
	
	
	@RequestMapping("demo4")
	public String demo4(People p) {
		System.out.println("DemoController.demo4()");
		System.out.println(p);
		return "main.jsp";
	}
	
	@RequestMapping("demo5")
	public String demo5(String name, int age, @RequestParam("hover") List<String> h) {
		System.out.println("DemoController.demo5()");
		System.out.println(name+","+age+","+h);
		
		return "main.jsp";
	}
	
	
	/**
	 * 	当表单input中 name="peo.name"，那需要准备一个类 包含属性peo，且peo有属性name
	 * @param demo
	 * @return
	 */
	@RequestMapping("demo6")
	public String demo6(Demo demo) {
		System.out.println("DemoController.demo6()");
		System.out.println(demo);
		
		return "main.jsp";
	}
	
	
	@RequestMapping("demo7")
	public String demo7(String name, int age) {
		System.out.println(name+", "+age);
		
		return "main.jsp";
	}
	
	/**
	 * 	restful 风格 
	 * 
	 * 	jsp: <a href="demo8/1234/abc2">link2</a>
	 * @param name 使用@PathVariable注解 取到mapping中对应的值
	 * @param age
	 * @return
	 */
	@RequestMapping("demo8/{age1}/{name1}")
	public String demo8(@PathVariable("name1")  String name, 
			@PathVariable("age1") int age) {
		System.out.println("DemoController.demo6()");
		System.out.println(name+", "+age);
		
		return "/main.jsp"; // 绝对路径，根目录下的。默认是 请求转发
	}
	
	
	/**
	 * 	@RuquestMapping(根目录下)
	 * 
	 * 
	 * 	当client请求 /proj/demo9 时，重定向后，url会变成 /proj/main.jsp
	 * 
	 * @return
	 */
	@RequestMapping("/demo9")
	public String demo9() {
		System.out.println("DemoController.demo9()");
		
		return "redirect:/main.jsp"; 
	}
	
	
	@RequestMapping("/demo10")
	public String demo10() {
		System.out.println("DemoController.demo10()");
		
		return "forward:demo11"; // 跳到另一个控制器
	}
	
	@RequestMapping("demo11")
	public String demo11() {
		System.out.println("DemoController.demo11()");
		
		
		return "main";
	}
	
	// ajax不用跳转，只有响应内容，实现：
	@RequestMapping("demo121")
	public void demo121(HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		
		PrintWriter out = resp.getWriter();
		out.print("今天下雨");
		out.flush();
		out.close();
		
	}
	
	/**
	 * 	设置@ResponseBody后，return值会被转换成json字符串，同时设置响应头类型 application/json
	 * 	提前导入 jackson的3个jar
	 * 
	 * 
	 * @return 默认是 需要跳转的，当设置@ResponseBody后，返回值不会跳转，而是转成流方式输出出去
	 * 	返回值能转成json就转，不能转的话，是text/html;
	 */
	@RequestMapping(value="demo12", produces="text/html;charset=utf-8")
	@ResponseBody
	public String demo12() {
		
//		return new People("张三", 12);
		return "下雨了";
	}
	
	
}
































