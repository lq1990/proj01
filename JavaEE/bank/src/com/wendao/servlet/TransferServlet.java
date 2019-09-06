package com.wendao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wendao.pojo.Account;
import com.wendao.service.AccountService;
import com.wendao.service.impl.AccountServiceImpl;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	private AccountService as = new AccountServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// set encoding
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		Account accOut = new Account();
		accOut.setAccno(req.getParameter("accOutAccNO"));
		accOut.setPassword(Integer.parseInt(req.getParameter("accOutPassword")));
		accOut.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
		
		System.out.println("---------\naccOut:");
		System.out.println(req.getParameter("accOutAccNO")); // null
		System.out.println(req.getParameter("accOutPassword")); // 123456
		System.out.println(req.getParameter("accOutBalance")); // 100
		
		
		Account accIn = new Account();
		accIn.setAccno(req.getParameter("accInAccNo"));
		accIn.setName(req.getParameter("accInName"));
		
		System.out.println("---------\naccIn:");
		System.out.println(req.getParameter("accInAccNo"));
		System.out.println(req.getParameter("accInName"));
		
		
		int index = as.transfer(accIn, accOut);
		if(index == AccountService.SUCCESS) {
			resp.sendRedirect("/bank/show");
			return;
		} else {
			req.getSession().setAttribute("code", index);
			resp.sendRedirect("/bank/error/error.jsp");
			return;
		}
		
	}
	
	
	
}















