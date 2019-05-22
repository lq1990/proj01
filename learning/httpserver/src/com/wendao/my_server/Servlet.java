package com.wendao.my_server;

/**
 * 父类
 * @author china
 *
 */
public abstract class Servlet {
	
	
	public void service(Request req, Response res) throws Exception {
		this.doGet(req, res);
		this.doPost(req, res);
	}
	
	public abstract void doGet(Request req, Response res) throws Exception;
	public abstract void doPost(Request req, Response res) throws Exception;
}

// 针对不同请求，比如login，home。使用工厂模式
