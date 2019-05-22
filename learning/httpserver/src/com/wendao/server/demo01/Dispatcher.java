package com.wendao.server.demo01;

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
		Servlet serv = new Servlet();
		serv.service(req, res);
		try {
			res.pushToClient(code); // 推送到client了
		} catch (IOException e) {
//			e.printStackTrace();
			try {
				res.pushToClient(500);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		CloseUtil.closeAll(client);
	}

}
