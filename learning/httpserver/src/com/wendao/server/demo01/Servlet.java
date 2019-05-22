package com.wendao.server.demo01;

public class Servlet {
	public void service(Request req, Response res) {
		res.println("<html><head><title>this is title</title></head>");
		res.println("<body>你好 "+ req.getParam("uname") + 
				". Welcome to my world.</body></html>");
		
	}
}
