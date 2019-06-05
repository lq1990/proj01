package com.wendao.server;

import java.io.IOException;
import java.net.Socket;

/**
 * 
 * 输入socket，
 * 
 * 多线程的入口函数在此
 * 
 * @author china
 *
 */
public class Dispatcher_old implements Runnable {
	private Socket client;
	private Request req;
	private Response res;

	public Dispatcher_old() {
	}

	public Dispatcher_old(Socket client) {
		this.client = client;
		try {
			this.req = new Request(client);
			this.res = new Response(client);
		} catch (IOException e) {
			this.release();
		}
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is working...");
		try {
			Servlet servlet = WebApp.getServletFromURL(req.getUrl());
			if (null != servlet) {
				servlet.service(req, res);
				res.pushToBrowser(200);
				
			} else {
				// not found any Servlet from the url, so NOT FOUND
				res.println("迷路了，呜呜呜");
				res.pushToBrowser(404);
			}
		} catch (IOException e) {
			try {
				res.pushToBrowser(505); // SERVER ERROR
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		// +++++++++++++++++++++ 短连接，长连接  +++++++++++++++++++++++++++++++++++
		this.release(); // 释放资源，否则阻塞。此为短连接，用完就释放，可提高性能。
		// 还有一种是 长连接，暂用资源，但可以保留状态。
		System.out.println("client is closed.");
		
	}

	/**
	 * free resource
	 */
	private void release() {
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
