package com.wendao.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 	作用域传值
 * @author china
 *
 */
@Controller
public class DemoController {
	
	/**
	 * 	query中paramater直接写在参数
	 * @param fileName
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("download")
	public void download(String file, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 设置响应流中文件进行下载
		resp.setHeader("Content-Disposition", "attachment;filename="+file);
		// 把二进制流放入到响应体中
		ServletOutputStream os = resp.getOutputStream();
		
		String path = req.getServletContext().getRealPath("files"); 
		System.out.println(path);
		File file2 = new File(path, file);
		
		// 使用commons.io 工具类
		byte[] bytes = FileUtils.readFileToByteArray(file2);
		os.write(bytes);
		os.flush();
		os.close();
		
	}
	
	
	/**
	 * 
	 * 	参数名file，必须和form中 <input type="file" name="file" />的name一致
	 * 
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("upload")
	public String upload(MultipartFile file, String username) throws IOException {
		System.out.println("username: "+username);
		
		// 对file持久化
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf(".")); // 含左不含右
		String uuid = UUID.randomUUID().toString(); // 生成随机字符串
		
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File("d:/"+uuid+suffix));
		
		return "/index.jsp";
	}
	
}
















