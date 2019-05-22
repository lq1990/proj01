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
 * 请求并相应。
 * 
 * @author china
 *
 */
public class Server4_useResponse {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";

	public static void main(String[] args) {
		Server4_useResponse server = new Server4_useResponse();
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
			Socket client = server.accept(); // 此时连接一个client
			StringBuilder sb = new StringBuilder();
			String msg = null; // 接收客户端的请求信息

			byte[] data = new byte[20480]; // 用来接收client发过来的信息
			int len = client.getInputStream().read(data);

			// 接收client(browser)的请求信息
			String reqInfo = new String(data, 0, len).trim();
			System.out.println(reqInfo);

			// ============= response =============
			Response res = new Response(client);
			res.println("<html><head><title>this is title</title></head>");
			res.println("<body>Oh, boys girls. Welcome to my world.</body></html>");
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
