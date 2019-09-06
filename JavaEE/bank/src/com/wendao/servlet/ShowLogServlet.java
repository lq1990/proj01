package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wendao.pojo.PageInfo;
import com.wendao.service.LogService;
import com.wendao.service.impl.LogServiceImpl;

/**
 * 	此控制器 从db中拿数据，
 * 	请求转发到 log.jsp中展示
 * @author china
 *
 */
@WebServlet("/show")
public class ShowLogServlet extends HttpServlet {
	private LogService ls = new LogServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req
		// 先设置默认值，即初次打开时
		int pageSize = 5;
		int pageNumber = 1;
		
		// 当req中有参数后
		String pageSizeStr = req.getParameter("pageSize");
		String pageNumberStr = req.getParameter("pageNumber");
		if(pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		if(pageNumberStr != null && !pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		PageInfo pi = ls.showPage(pageSize, pageNumber);
		req.setAttribute("pageinfo", pi);
		
		// resp
		req.getRequestDispatcher("/log.jsp").forward(req, resp);
		return;

		
	}

}












