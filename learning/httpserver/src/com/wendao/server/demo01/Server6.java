package com.wendao.server.demo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 请求并响应。
 * 
 * @author china
 *
 */
public class Server6 {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";

	public static void main(String[] args) {
		Server6 server = new Server6();
		server.start();
	}

	/**
	 * 启动方法
	 */
	public void start() {
		try {
			server = new ServerSocket(9999);
			System.out.println("--- server is running... ---\r\n");

			this.receive();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 接收客户端
	 */
	private void receive() {
		try {
			Socket client = this.server.accept(); // 此时连接一个client
			
			Request req = new Request(client.getInputStream()); // 处理来自client的req
			Response res = new Response(client);
			Servlet serv = new Servlet();
			serv.service(req, res);
			res.pushToClient(200);
			
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}

	/**
	 * 停止服务器
	 */
	public void stop() {

	}
}
