package com.wendao.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

	/**
	 * 	在servlet中，把图片以流的方式，传给client，浏览器解析。
	 *  
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		// 输出文字流
//		PrintWriter out = resp.getWriter();
		
		
		// 获取响应流
		ServletOutputStream os = resp.getOutputStream();
		InputStream is = new FileInputStream(
				new File(getServletContext().getRealPath("imgs"), "noise.jpg"));
		
		// is ==> os
		int index = -1;
		while((index=is.read()) != -1) {
			os.write(index);
		}
		
		
		
		
	}

}















