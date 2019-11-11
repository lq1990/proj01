package com.wendao.atcrowdfunding.controller;

import java.text.SimpleDateFormat;
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
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@ResponseBody
	@RequestMapping("/deletes")
	public Object deletes(Integer[] roleid) {
		AJAXResult result = new AJAXResult();
		
		
		try {
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("roleids", roleid);
			
			roleService.deleteRoles(map);
			
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
			roleService.deleteRoleById(id);
			
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
	public Object update(Role role) {
		AJAXResult result = new AJAXResult();
		
		try {
			roleService.updateRole(role);
			
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
		
		Role role = roleService.queryById(id);
		model.addAttribute("role", role); // 把user信息存起来，在jsp中显示
		
		
		return "role/edit";
	}
	
	/**
	 * 	把user数据insert到db中
	 * 	ajax的话return Object
	 */
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert(Role role) {
		AJAXResult result = new AJAXResult();
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			
			roleService.insertRole(role);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result; // 结果返回给ajax中的success中
	}
	
	@RequestMapping("/add")
	public String add() {
		
		return "role/add";
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
			List<Role> roles = roleService.pageQuery(map);
			
			// 总条数
			int totalsize = roleService.pageQueryCount(map);
			
			// 最大页码（总页码）
			int totalno = 0;
			if (totalsize % pagesize == 0) {
				totalno = totalsize / pagesize;
			} else {
				totalno = totalsize / pagesize + 1;
			}
			
			
			// 在异步中，不跳转页面，用不到model
			// 但：需要把 users, pageno, totalno 传给页面
			Page<Role> rolePage = new Page<Role>();
			rolePage.setDatas(roles);
			rolePage.setTotalno(totalno);
			rolePage.setTotalsize(totalsize);
			rolePage.setPageno(pageno);

			
			
			result.setSuccess(true);
			result.setData(rolePage);
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@RequestMapping("/index")
	public String index() {
		
		return "role/index";
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
		List<Role> roles = roleService.pageQuery(map);
		
		// 把分页查询结果放到model中
		model.addAttribute("roles", roles);
		
		// 当前页
		model.addAttribute("pageno", pageno);
		
		// 总条数
		int totalsize = roleService.pageQueryCount(map);
		
		// 最大页码（总页码）
		int totalno = 0;
		if (totalsize % pagesize == 0) {
			totalno = totalsize / pagesize;
		} else {
			totalno = totalsize / pagesize + 1;
		}

		model.addAttribute("totalno", totalno);
		
		return "role/index";
	}
	
	
}











