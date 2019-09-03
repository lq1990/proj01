package com.wendao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wendao.pojo.Flower;
import com.wendao.service.FlowerService;
import com.wendao.service.impl.FlowerServiceImpl;

public class ShowServlet extends HttpServlet {
	// 多用户同时访问的话，不能再service中new FlowerServiceImpl()，因为每个用户都要new一个，内存暂用大。
	private FlowerService flowerService = new FlowerServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// encoding
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		List<Flower> list = new ArrayList<Flower>();
		
		// get data from db
		list = flowerService.show();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
		
	}

}
