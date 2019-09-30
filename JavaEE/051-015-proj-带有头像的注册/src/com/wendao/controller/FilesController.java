package com.wendao.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wendao.pojo.Users;
import com.wendao.service.FilesService;

@Controller
public class FilesController {
	
	@Resource
	private FilesService filesServiceImpl;
	
	
	@RequestMapping("show")
	public String show(Model model) {
		model.addAttribute("list", filesServiceImpl.show());
		
		return "/main.jsp";
	}	
	
	@RequestMapping("download")
	public void download(int id, String name, HttpServletResponse resp, HttpServletRequest req) throws IOException {
		int index = filesServiceImpl.updCount(id, (Users)req.getSession().getAttribute("user"), name);
		
		resp.setHeader("Content-Disposition", "attachment;filename="+name);
		ServletOutputStream os = resp.getOutputStream();
		
		File f = new File(req.getServletContext().getRealPath("files"), name);
		os.write(FileUtils.readFileToByteArray(f));
		os.flush();
		os.close();
		
	}
}












