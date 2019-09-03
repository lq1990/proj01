package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wendao.pojo.Flower;
import com.wendao.service.FlowerService;
import com.wendao.service.impl.FlowerServiceImpl;

/**
 *  url中 /flower/insert时 就是调用这个servlet
 * @author china
 *
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private FlowerService fs = new FlowerServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// encoding
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 从花卉form表单中 拿数据
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String production = req.getParameter("production");
		
		Flower f = new Flower();
		f.setName(name);
		f.setPrice(Double.parseDouble(price));
		f.setProduction(production);
		int index = fs.add(f);

		if(index > 0) {
			resp.sendRedirect("show");
		} else {
			resp.sendRedirect("add.jsp");
		}
		
		// 使用重定向而非 请求转发，为了：防止表单重复提交
		
	}

}










