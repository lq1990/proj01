package com.wendao.user;

import com.wendao.server.core.Request;
import com.wendao.server.core.Response;
import com.wendao.server.core.Servlet;

/**
 * 
 * @author china
 *
 */
public class OthersServlet implements Servlet {
	
	@Override
	public void service(Request req, Response res) {
		res.println("other pages");
		
	}
}
