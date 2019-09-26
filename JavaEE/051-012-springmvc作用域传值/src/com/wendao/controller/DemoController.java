package com.wendao.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 	作用域传值
 * @author china
 *
 */
@Controller
public class DemoController {
	
	/**
	 * 	在参数中，不能有ServletContext，不允许注入
	 * @param req
	 * @param sessionParam
	 * @return
	 */
	@RequestMapping("demo1")
	public String demo1(HttpServletRequest req, HttpSession sessionParam) {
		req.setAttribute("req", "req的值");
		
		req.getSession().setAttribute("ss", "ss的值");
		sessionParam.setAttribute("ssParam", "ssParam的值");
		
		ServletContext app = req.getServletContext();
		app.setAttribute("app", "app的值");
		
		return "/index.jsp";
	}
	
	/**
	 * 	先请求demo1，session中有值后，请求demo2时 可以取得session中的值
	 * @param session
	 * @return
	 */
	@RequestMapping("demo2")
	public String demo2(HttpSession session) {
		Object attribute = session.getAttribute("ss");
		System.out.println(attribute);
		
		return "/index.jsp";
	}
	
	
	/**
	 * 	map会在requestScope.
	 * 	当取值时 借助key
	 * @param map
	 * @return
	 */
	@RequestMapping("demo3")
	public String demo3(Map<String, Object> map) {
		map.put("map", "map的值");
		System.out.println(map.getClass());
		
		return "/index.jsp";
	}
	
	/**
	 *  Model也是在requestScope
	 * @param model
	 * @return
	 */
	@RequestMapping("demo4")
	public String demo4(Model model) {
		model.addAttribute("model", "model的值");
		
		return "index.jsp";
	}
	
	@RequestMapping("demo5")
	public ModelAndView demo5() {
		// 参数，跳转视图
		ModelAndView mav = new ModelAndView("index.jsp");
		mav.addObject("mav", "mav的值");
		
		return mav;
		
	}
	
}
















