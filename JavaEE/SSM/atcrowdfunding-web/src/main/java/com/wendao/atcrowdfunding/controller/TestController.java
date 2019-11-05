package com.wendao.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wendao.atcrowdfunding.bean.User;
import com.wendao.atcrowdfunding.service.UserService;

/**
 * 	/test/index
 * @author china
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private UserService userServiceImpl;
	
	@ResponseBody
	@RequestMapping("/queryAll")
	public Object queryAll() {
		
		System.out.println(userServiceImpl.getClass().getName());
		
		List<User> users = userServiceImpl.queryAll();
		
		return users;
	}

	@RequestMapping("/index")
	public String index() {
		
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/json")
	public Object json() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username1", "zhangsan");
		map.put("username2", "lisi");
		return map;
	}
	
}
