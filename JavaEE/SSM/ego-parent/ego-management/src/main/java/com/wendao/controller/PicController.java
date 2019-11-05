package com.wendao.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.wendao.pojo.Pic;
import com.wendao.service.PicService;

@Controller
public class PicController {

	/**
	 * 有了Resource注解，就可以从spring大容器中取资源用
	 */
	@Resource
	private PicService picServiceImpl;

	/**
	 * RequestMapping的 insert前面后自动加 /
	 * 
	 * 图片copy到 files文件夹中， 而db中存的是pic的String path, 再main.jsp显示时，按照path从files中取出对应的图片
	 */
	@RequestMapping("insert")
	public String insert(MultipartFile file, HttpServletRequest req) {

		// 图片copy到files文件夹
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(),
					new File(req.getServletContext().getRealPath("files"), file.getOriginalFilename()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 在db新增
		Pic pic = new Pic();
		pic.setPath(file.getOriginalFilename());
		int index = picServiceImpl.insPic(pic);
		if (index > 0) {
			return "redirect:/show";
		} else {
			return "/add.jsp";
		}

	}

	@RequestMapping("show")
	public String show(Model model) {
		// 往model中添加属性。在jsp中取出用
		model.addAttribute("list", picServiceImpl.show());

		return "/main.jsp";
	}

	/**
	 * 	url中的参数会自动与 此fn的参数匹配.
	 * 
	 * 	delete db中的row，并不是删除files中图片文件
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(int id) {
		int idx = picServiceImpl.delById(id);
		return "redirect:/show";

	}

}
