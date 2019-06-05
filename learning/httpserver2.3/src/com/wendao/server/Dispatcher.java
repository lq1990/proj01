package com.wendao.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 
 * 输入socket，
 * 
 * 多线程的入口函数在此
 * 
 * 分发器：加入状态内容处理 404 505 home
 * 
 * @author china
 *
 */
public class Dispatcher implements Runnable {
	private Socket client;
	private Request req;
	private Response res;

	public Dispatcher() {
	}

	public Dispatcher(Socket client) {
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
			if (null == req.getUrl() || req.getUrl().equals("/") || req.getUrl().equals("")) {
				// home
				System.out.println("home page");
				InputStream is = 
						Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");

				String cont = this.is2String(is);
				
				res.print(cont);
				res.pushToBrowser(200);

				is.close();
				return;
			}

			Servlet servlet = WebApp.getServletFromURL(req.getUrl());
			if (null != servlet) {
				servlet.service(req, res);
				res.pushToBrowser(200);

			} else {
				// not found any Servlet from the url, so NOT FOUND
//				res.println("迷路了，呜呜呜");
				// +++++++++ 读取 html 文件，定位这个文件只能通过类加载器 ++++++++++++++++++++++++++
				InputStream is = 
						Thread.currentThread().getContextClassLoader().getResourceAsStream("NotFound.html");

				String datas = this.is2String(is);
				res.print(datas);
				res.pushToBrowser(404);
				is.close();
			}
		} catch (IOException e) {
			try {
				res.println("Server is tired, he needs a break.");
				res.pushToBrowser(505); // SERVER ERROR
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {

			// +++++++++++++++++++++ 短连接，长连接 +++++++++++++++++++++++++++++++++++
			this.release(); // 释放资源，否则阻塞。此为短连接，用完就释放，可提高性能。
			// 还有一种是 长连接，暂用资源，但可以保留状态。
			System.out.println("client is closed.");
		}

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
	
	private String is2String(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		StringBuilder sb = new StringBuilder();
		String line = null;
		while((line = br.readLine()) != null) {
			// read line by line
			sb.append(line);
		}
		
		return sb.toString();
	}

}
