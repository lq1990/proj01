package com.wendao.server.demo03;

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
	}
	
	public boolean login(String name, String pwd) {
		// 用户名，密码
		return name.equals("bjsxt") && pwd.equals("123456");
	}

	@Override
	public void doPost(Request req, Response res) throws Exception {

	}

}
