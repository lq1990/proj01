package com.wendao.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;

/**
 * 	目标：
 * 	01 使用ServerSocket与client即browser连接，获取 req 协议。
 * 	02 返回 res 协议
 * 	03 封装 res 信息
 * 		内容可以动态添加
 * 		只关注状态码
 * 	04 封装 req 信息
 * 	05 Request 封装了获取参数的方法
 * 	06 servlet 的使用，解耦了业务代码
 * 		
 * 
 * @author china
 *
 */
public class Server06 {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		Server06 server = new Server06();
		server.start();
		
	}
	
	// 启动服务
	public void start() {
		try {
			this.serverSocket = new ServerSocket(8888);
			System.out.println("server is running...");
			
			this.receive(); // receive clients after starting
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
		}
	}
	
	// 接受连接处理
	public void receive() {
		try {
			Socket client = this.serverSocket.accept();
			System.out.println("一个client建立了连接");
			
			Request req = new Request(client);
			Response res = new Response(client);
			Servlet servlet = null;
			
			// 此处用 一堆if/else，太繁乱，不利于后续扩展。改进：可用xml 反射
			if (req.getUrl().equals("/login")) {
				servlet = new LoginServlet();
			} else if (req.getUrl().equals("/reg")) {
				servlet = new RegisterServlet();
			} else {
				// home
				
			}
			
			servlet.service(req, res);
			// 关注了状态码
			res.pushToBrowser(200);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
		
	}
	
	// 启动服务
	public void stop() {

	}
}
