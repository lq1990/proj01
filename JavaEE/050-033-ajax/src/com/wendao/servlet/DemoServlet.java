package com.wendao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wendao.pojo.Users;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8"); // json使用的头
		
		System.out.println("执行控制器");
		
		// 2json，要响应的数据
		Users u = new Users(1, "张三", "123");
		Users u2 = new Users(11, "张三2", "1234");
		List<Users> list = new ArrayList<Users>();
		list.add(u);
		list.add(u2);
		
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(list);
		
		
		PrintWriter out = resp.getWriter();
		out.println(result);
		out.flush();
		out.close();
		
	}

}
