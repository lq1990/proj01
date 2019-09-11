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

@WebServlet("/showland")
public class ShowLandServlet extends HttpServlet {
	private AirportService as = new AirportServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Airport> list = as.showLandPort();
		req.setAttribute("landport", list);
		req.getRequestDispatcher("showairplane").forward(req, resp);
		return;
	}

}
