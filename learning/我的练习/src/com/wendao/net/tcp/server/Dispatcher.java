package com.wendao.net.tcp.server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Map;

public class Dispatcher implements Runnable {
	private Request req;
	private Response res;
	private Socket socket;

	/**
	 * @param req
	 * @param res
	 */
	public Dispatcher(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		System.out.println("+++++++++++ "+Thread.currentThread().getName()+" is running..."+" ++++++++++++");
		// 3 get data from client, 处理client的request
		this.req = new Request(socket);
		String url = req.getURL();
		Map<String, String> paramsMap = req.getPramsMap();

		System.out.println(url);
		System.out.println(paramsMap);

		// 4. response
		this.res = new Response(socket, paramsMap);
		if (url.equals("/favicon.ico")) {
			System.out.println("---------- req icon -----------");
			try {
				res.sendToClient(404);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			res.sendToClient(200);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
