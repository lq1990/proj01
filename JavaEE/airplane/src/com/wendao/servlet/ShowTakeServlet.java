package com.wendao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wendao.pojo.Airport;
import com.wendao.service.AirportService;
import com.wendao.service.impl.AirportServiceImpl;

@WebServlet("/showtake")
public class ShowTakeServlet extends HttpServlet {
	private AirportService as = new AirportServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("takeport", as.showTakePort());
		
		req.getRequestDispatcher("showland").forward(req, resp);
		return;
	}

}
