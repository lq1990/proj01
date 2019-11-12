package com.wendao.atcrowdfunding.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wendao.atcrowdfunding.bean.AJAXResult;
import com.wendao.atcrowdfunding.bean.Permission;
import com.wendao.atcrowdfunding.bean.User;
import com.wendao.atcrowdfunding.service.PermissionService;
import com.wendao.atcrowdfunding.service.UserService;

/**
 * 用来跳转页面
 * 
 * @author china
 *
 */
@Controller
public class DispatcherController {
	
	@Autowired
	private PermissionService permissionServiceImpl;

	@Autowired
	private UserService userService;

	/**
	 * 登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {

		return "login"; // springmvc配置文件中配置了 视图解析器，所以直接写即可
		//  name="prefix" value="/WEB-INF/jsp/"
	}
	
	
	
	@RequestMapping("/error")
	public String error() {
		
		return "error";
	}
	
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
//		session.removeAttribute("loginUser");
		session.invalidate(); // session失效，使得session中所有数据删除了
		
		return "redirect:login"; // localhost/login，重定向后交给控制器
	}
	
	
	@RequestMapping("/main")
	public String main() {
		
		return "main";
	}

	/**
	 * 执行登录功能
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/dologin")
	public String doLogin(User user, Model model) throws Exception {
		String loginacct = user.getLoginacct();

		// 将乱码字符串 按照 错误的编码方式 转换为 原始的字节码序列
//		byte[] bs = loginacct.getBytes("iso8859-1");

		// 将原始的字节码序列 按照 正确的编码 转换为 正确的文字
//		loginacct = new String(bs, "utf-8");

		// 1. 获取表单数据
		// 1.1. 通过HttpServletRequest
		// 1.2. 在方法参数列表中，增加表单对应的参数，名称应相同
		// 1.3. 将表单数据封装为实体类对象

		// 2. 查询用户信息
		User dbUser = userService.query4Login(user);

		// 3. 判断用户信息是否存在
		if (dbUser != null) {
			// success，跳转到主页面
			return "main";
		} else {
			// 登录失败，跳转回到登录页面，提示错误信息
			String errorMsg = "登录账号或密码不正确，请重新登录！";
			model.addAttribute("errorMsg", errorMsg);

			return "redirect:login";
		}

	}

	/**
	 * ResponseBody使得Object可在网络中传递，为json字符串格式
	 * 
	 * 	从jsp传过来的param会封到user中
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/doAJAXLogin")
	public Object doAJAXLogin(User user, HttpSession session) {
		AJAXResult result = new AJAXResult();
		
		User dbUser = userService.query4Login(user);

		// 3. 判断用户信息是否存在
		if (dbUser != null) {
			session.setAttribute("loginUser", dbUser);
			
			// 获取用户权限信息
			List<Permission> perms = permissionServiceImpl.queryPermissionsByUser(dbUser);
			
			Map<Integer, Permission> pMap = new HashMap<Integer, Permission>();
			Permission root = null;
			
			Set<String> uriSet = new HashSet<String>();
			
			for (Permission permission : perms) {
				pMap.put(permission.getId(), permission);
				if (permission.getUrl() != null && !"".equals(permission.getUrl())) {
					uriSet.add(session.getServletContext().getContextPath()
							+ permission.getUrl());
				}
			}
			
			session.setAttribute("authUriSet", uriSet);
			
			for (Permission permission : perms) {
				Permission child = permission;
				if (child.getPid() == 0) {
					root = child;
				} else {
					Permission parent = pMap.get(child.getPid());
					parent.getChildren().add(child);
				}
			}
			
			session.setAttribute("root", root);
			result.setSuccess(true);
			
		} else {
			result.setSuccess(false);
		}
		
		return result;
	}

}
