package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wendao.pojo.PageInfo;
import com.wendao.service.PeopleService;
import com.wendao.service.impl.PeopleServiceImpl;

/**
 * 	Servlet 是Controller
 * 	从service处取得数据，交给jsp展示
 * @author china
 *
 */
@WebServlet("/show")
public class ShowPageServlet extends HttpServlet {
	private PeopleService ps = new PeopleServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 第一次访问的验证，如果没有传递参数，设置默认值
		String pageSizeStr = req.getParameter("pageSize");
		int pageSize = 2;
		if(pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}

		String pageNumberStr = req.getParameter("pageNumber");
		int pageNumber = 1;
		if(pageNumberStr != null && !pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		// resp
		PageInfo pi = ps.showPage(pageSize, pageNumber);
		req.setAttribute("PageInfo", pi);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}














