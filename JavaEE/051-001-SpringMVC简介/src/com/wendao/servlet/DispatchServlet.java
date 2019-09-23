package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * /的话，不过滤jsp, 自动放行jsp，jsp中内容会被直接显示到client。 其它类型资源会过滤，即执行service。
 * 
 * /* 的话，所有资源都会执行service
 * 
 * 
 * 
 * 	根据url中parameter进行 if/else，是 front(前端)设计模式。
 * 	因为 配置的是/，所以除了jsp之外的所有请求都会走servlet，
 * 
 * @author china
 *
 */
@WebServlet("/")
public class DispatchServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		String ctl = req.getParameter("control");
		if (ctl.equals("demo1")) {
			demo1(req, resp);
		} else if (ctl.equals("demo2")) {
			demo2();
		} else if (ctl.equals("demo3")) {
			demo3();
		} else if (ctl.equals("demo4")) {
			demo4();
		}

	}



	private void demo1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DispatchServlet.demo1()");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}

	private void demo2() {
		System.out.println("DispatchServlet.demo2()");
	}

	private void demo3() {
		// TODO Auto-generated method stub
		System.out.println("DispatchServlet.demo3()");
	}
	
	private void demo4() {
		// TODO Auto-generated method stub
		System.out.println("DispatchServlet.demo4()");
	}
	
	
	
}

