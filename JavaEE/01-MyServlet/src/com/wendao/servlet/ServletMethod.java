package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMethod extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("我是service");
//		super.service(req, res); // 父类的service会根据get或post不同调用相应的doGet(),doPost()
		// 所以，super.service(req,res)通常删掉，如果写super.service(req,res)，则必须子类实现doGet(),doPost()
		
	}
	
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("我是 doGet方法");
//	}
//	
//	
//	@Override
//		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			System.out.println("我是doPost方法");
//		}
	
	
}
