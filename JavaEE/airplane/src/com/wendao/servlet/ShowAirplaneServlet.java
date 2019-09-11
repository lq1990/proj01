package com.wendao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wendao.pojo.Airplane;
import com.wendao.service.AirplaneService;
import com.wendao.service.impl.AirplaneServiceImpl;

@WebServlet("/showairplane")
public class ShowAirplaneServlet extends HttpServlet {
	private AirplaneService as = new AirplaneServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int takeid = 0;
		int landid= 0;
		String takeidStr = req.getParameter("takeid");
		String landidStr = req.getParameter("landid");
		
		if(takeidStr != null && !takeidStr.equals("")) {
			takeid = Integer.parseInt(takeidStr);
		}
		if(landidStr != null && !landidStr.equals("")) {
			landid = Integer.parseInt(landidStr);
		}
		
		List<Airplane> list = as.show(takeid, landid);
		req.setAttribute("listAirplane", list);

		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		return;
	}
	
}

















