package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wendao.pojo.People;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet{
	private People people;
	private People people2;
	
	private ApplicationContext ac;
	
	@Override
	public void init() throws ServletException {
		ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		people = ac.getBean("peo", People.class);
		people2 = ac.getBean("peo", People.class);
		System.out.println("people: "+people);
		System.out.println("people2: "+people2);
		
	}

}













