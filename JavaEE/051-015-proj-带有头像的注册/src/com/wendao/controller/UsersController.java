package com.wendao.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.wendao.pojo.Users;
import com.wendao.service.UsersService;

@Controller
public class UsersController {

	@Resource
	private UsersService usersServiceImpl;

	@RequestMapping("/register")
	public String register(Users users, MultipartFile file, HttpServletRequest req) throws IOException {
		System.out.println("来自表单数据，users:");
		System.out.println(users);
		
		String fileName = UUID.randomUUID().toString()
				+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String path = req.getServletContext().getRealPath("images") + "/" + fileName;
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));

		// 只能取到webapps文件夹内容
		users.setPhoto(fileName);
		int index = usersServiceImpl.insRegister(users);
		
		if (index > 0) {
			req.getSession().setAttribute("user", users); // 为记录日志的
			return "redirect:/show";

		} else {
			return "redirect:/register.jsp";
		}

	}
}











