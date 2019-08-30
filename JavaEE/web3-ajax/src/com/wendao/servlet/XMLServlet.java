package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/xml")
public class XMLServlet extends HttpServlet {

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// encoding
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/xml;charset=utf-8");
			
			// req
			
			
			// resp
			resp.getWriter().write("<user>"
					+ "<uid>1</uid>"
					+ "<uname>xml</uname>"
					+ "<price>222</price>"
					+ "<loc>bj</loc>"
					+ "<des>jfkajg;j;</des>"
					+ "</user>");
			
		}
		
}
