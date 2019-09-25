package com.wendao.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wendao.pojo.Menu;
import com.wendao.service.MenuService;


/**
 * 	按db中table写controller
 * @author china
 * 
 *	@Controller 把当前类交给SpringMVC管理
 */
@Controller
public class MenuController {
	
	/** 
	 * @Resource默认byName注入
	 * 	本质上：SpringMVC容器调用Spring容器中内容
	 */
	@Resource
	private MenuService menuServiceImpl;
	
	@RequestMapping("show")
	@ResponseBody
	public List<Menu> show(){
		
		return menuServiceImpl.show();
	}
	
	
	
	
	
	
	
	
	
}
