package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wendao.service.AirportService;
import com.wendao.service.impl.AirportServiceImpl;

@WebServlet("/airport")
public class AirportServlet extends HttpServlet {
	private AirportService as;

	
	@Override
	public void init() throws ServletException {
		// 对service实例化
//		ApplicationContext ac = new ClassPathXmlApplicationContext("");
		
		// spring和web整合后，所有信息都存放在WebApplicationContext
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		as = ac.getBean("airportService", AirportServiceImpl.class);
		

		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//
		req.setAttribute("list", as.show());
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		return;
	}

}
