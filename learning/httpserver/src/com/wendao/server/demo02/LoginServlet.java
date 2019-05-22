package com.wendao.server.demo02;

/**
 * 
 * @author china
 *
 */
public class LoginServlet extends Servlet {

	@Override
	public void doGet(Request req, Response res) throws Exception {
		String uname = req.getParam("uname");
		String pwd = req.getParam("pwd");
		if (this.login(uname, pwd)) {
			res.println("登录成功"); // 这里写网页很麻烦，所有jsp登场
		} else {
			res.println("登录失败！！！");
		}
		
//		res.println("<html><head><title>登录</title></head>");
//		res.println("<body>你好 " + req.getParam("uname") + 
//				". Welcome to my world.</body></html>");
	}
	
	public boolean login(String name, String pwd) {
		return name.equals("bjsxt") && pwd.equals("123456");
	}

	@Override
	public void doPost(Request req, Response res) throws Exception {

	}

}
