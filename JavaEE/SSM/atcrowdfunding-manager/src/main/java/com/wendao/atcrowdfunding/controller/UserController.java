package com.wendao.atcrowdfunding.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wendao.atcrowdfunding.bean.AJAXResult;
import com.wendao.atcrowdfunding.bean.Page;
import com.wendao.atcrowdfunding.bean.Role;
import com.wendao.atcrowdfunding.bean.User;
import com.wendao.atcrowdfunding.service.RoleService;
import com.wendao.atcrowdfunding.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	/**
	 *  op db
	 *  把 selected unassignroleids 增到db
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/doAssign")
	public Object doAssign(Integer userid, Integer[] unassignroleids) {
		AJAXResult result = new AJAXResult();
		
		try {
			// 增加关系表数据
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userid", userid);
			map.put("roleids", unassignroleids);
			
			userService.insertUserRoles(map);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/dounAssign")
	public Object dounAssign(Integer userid, Integer[] assignroleids) {
		AJAXResult result = new AJAXResult();
		
		
		try {
			// 删除关系表数据
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userid", userid);
			map.put("roleids", assignroleids);
			
			userService.deleteUserRoles(map);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping("/deletes")
	public Object deletes(Integer[] userid) {
		AJAXResult result = new AJAXResult();
		
		
		try {
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userids", userid);
			
			userService.deleteUsers(map);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object delete(Integer id) {
		AJAXResult result = new AJAXResult();
		
		try {
			userService.deleteUserById(id);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	/**
	 * 	jsp中ajax请求过来的
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object update(User user) {
		AJAXResult result = new AJAXResult();
		
		try {
			userService.updateUser(user);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	@RequestMapping("/edit")
	public String edit(Integer id, Model model) {
		// 到修改页面时，需要把被修改的数据显示在页面
		
		User user = userService.queryById(id);
		model.addAttribute("user", user); // 把user信息存起来，在jsp中显示
		
		
		return "user/edit";
	}
	
	/**
	 * 	分配给用户 角色
	 * @param id
//	 * @return
	 */
	@RequestMapping("/assign")
	public String assign(Integer id, Model model) {
		User user = userService.queryById(id);
		model.addAttribute("user", user); // 把user信息存起来，在jsp中显示
		
		// 从db中取到所有的角色
		List<Role> roles = roleService.queryAll();
		model.addAttribute("roles", roles);
		
		List<Role> assignedRoles = new ArrayList<Role>();
		List<Role> unassignedRoles = new ArrayList<Role>();
		
		// 获取关系表中的数据
		List<Integer> roleids = userService.queryRoleidsByUserids(id);
		
		for (Role role : roles) {
			if (roleids.contains(role.getId())) {
				assignedRoles.add(role);
			} else {
				unassignedRoles.add(role);
			}
		}
		
		model.addAttribute("assignedRoles", assignedRoles);
		model.addAttribute("unassignedRoles", unassignedRoles);
		return "/user/assign";
	}
	
	/**
	 * 	把user数据insert到db中
	 * 	ajax的话return Object
	 */
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert(User user) {
		AJAXResult result = new AJAXResult();
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			
			user.setCreatetime(sdf.format(new Date()));
			user.setPwd("123456"); // 因为是管理员新增的用户，默认给定密码
			userService.insertUser(user);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result; // 结果返回给ajax中的success中
	}
	
	@RequestMapping("/add")
	public String add() {
		
		return "user/add";
	}
	
	/**
	 *  异步分页用的
	 * @param pageno
	 * @param pagesize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/pageQuery")
	public Object pageQuery(String queryText, Integer pageno, Integer pagesize) {
		
		AJAXResult result = new AJAXResult();
		
		try {
			// 分页查询
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", (pageno-1)*pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);
			
			// 分页查询
			List<User> users = userService.pageQuery(map);
			
			// 总条数
			int totalsize = userService.pageQueryCount(map);
			
			// 最大页码（总页码）
			int totalno = 0;
			if (totalsize % pagesize == 0) {
				totalno = totalsize / pagesize;
			} else {
				totalno = totalsize / pagesize + 1;
			}
			
			
			// 在异步中，不跳转页面，用不到model
			// 但：需要把 users, pageno, totalno 传给页面
			Page<User> userPage = new Page<User>();
			userPage.setDatas(users);
			userPage.setTotalno(totalno);
			userPage.setTotalsize(totalsize);
			userPage.setPageno(pageno);

			
			
			result.setSuccess(true);
			result.setData(userPage);
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@RequestMapping("/index")
	public String index() {
		
		return "user/index";
	}
	
	/**
	 * 	用户首页
	 * @param pageno 分页查询的 页码
	 * @param pagesize 分页查询的 每页多少条
	 * @return
	 */
	@RequestMapping("/index1")
	public String index1(@RequestParam(required=false, defaultValue="1") Integer pageno, 
			@RequestParam(required=false, defaultValue="2") Integer pagesize, Model model) {
		// limit start,size
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", (pageno-1)*pagesize);
		map.put("size", pagesize);
		
		// 分页查询
		List<User> users = userService.pageQuery(map);
		
		// 把分页查询结果放到model中
		model.addAttribute("users", users);
		
		// 当前页
		model.addAttribute("pageno", pageno);
		
		// 总条数
		int totalsize = userService.pageQueryCount(map);
		
		// 最大页码（总页码）
		int totalno = 0;
		if (totalsize % pagesize == 0) {
			totalno = totalsize / pagesize;
		} else {
			totalno = totalsize / pagesize + 1;
		}

		model.addAttribute("totalno", totalno);
		
		return "user/index";
	}
	
	
}











