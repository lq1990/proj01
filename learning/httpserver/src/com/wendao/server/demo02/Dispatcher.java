package com.wendao.server.demo02;

import java.io.IOException;
import java.net.Socket;

/**
 * 一个请求与相应，就一个此分发器
 * @author china
 *
 */
public class Dispatcher implements Runnable {
	private Socket client;
	private Request req;
	private Response res;
	private int code = 200;
	
	/**
	 * @param client
	 * @param req
	 * @param res
	 */
	public Dispatcher(Socket client) {
		super();
		this.client = client;
		try {
			this.req = new Request(client.getInputStream());
			this.res = new Response(client.getOutputStream());
		} catch (IOException e) {
			code = 500;
			return ;
		}
		
	}

	@Override
	public void run() {
		
		try {
			Servlet serv = WebApp.getServlet(this.req.getURL());
			if (null == serv) {
				this.code = 404;
			} else {
				serv.service(req, res);
			}
			
			res.pushToClient(code); // 推送到client了
		} catch (Exception e) {
			this.code = 500;
			try {
				res.pushToClient(500);
			} catch (IOException e1) {
//				e1.printStackTrace();
			}
			
		}
		
		CloseUtil.closeAll(client);
	}

}
