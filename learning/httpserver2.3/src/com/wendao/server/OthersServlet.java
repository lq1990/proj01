package com.wendao.server;

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
