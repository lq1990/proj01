package com.wendao.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wendao.pojo.PageInfo;
import com.wendao.service.StudentService;
import com.wendao.service.impl.StudentServiceImpl;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	private StudentService stuService = new StudentServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sname = req.getParameter("sname");
		String tname = req.getParameter("tname");
		String pageSize = req.getParameter("pageSize");
		String pageNumber = req.getParameter("pageNumber");
		PageInfo pi = stuService.showPage(sname, tname, pageSize, pageNumber);
		
		req.setAttribute("pageinfo", pi);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}
	
}
