package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wendao.pojo.User;
import com.wendao.service.UserService;
import com.wendao.serviceImpl.UserServiceImpl;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// encoding
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// req
		String uname = req.getParameter("uname");
		System.out.println("uname:"+uname);
		// 处理请求信息
			// 获取业务层对象
			UserService us = new UserServiceImpl();
			User u = us.getUserInfo(uname);
			
			if(u!=null) {
				System.out.println(u);
				// resp。这里字符串拼接成一个json，在jsp中js用eval()执行
				// 1. 传统js格式
//				resp.getWriter().write("var obj={};"
//						+ "obj.uname='"+u.getUname()+"';"
//						+ "obj.uid='"+u.getUid()+"';"
//						+ "obj.price='"+u.getPrice()+"';"
//						+ "obj.loc='"+u.getLoc()+"';"
//						+ "obj.des='"+u.getDes()+"';"
//						);
				
				// 2. json "var obj={k:v, k:v, ...};" 
				// 把 var obj= 不写，而是放到jsp的js中 eval("var obj = "+result)
//				resp.getWriter().write("{"
//						+ "uname: '"+u.getUname()+"', "
//						+ "uid: "+u.getUid()+", "
//						+ "price: "+u.getPrice()+", "
//						+ "loc: '"+u.getLoc()+"', "
//						+ "des: '"+u.getDes()+"'"
//								+ "}");
				
				// 2.1 使用gson包，将User对象 转为 json拼接字符串
				resp.getWriter().write(new Gson().toJson(u));
				
				
				// -----------------------------------------------
				// XML格式对u进行存储
//				resp.getWriter().write("<user>"
//						+ "<uid>1</uid>"
//						+ "<uname>anna</uname>"
//						+ "<price>222</price>"
//						+ "<loc>bj</loc>"
//						+ "<des>jfkajg;j;</des>"
//						+ "</user>");
				
				
			} else {
				System.out.println("not found");
				resp.getWriter().write("not found");
			}
		
	}
	
}





















