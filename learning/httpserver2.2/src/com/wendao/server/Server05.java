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
 * 	01 使用ServerSocket与client即browser连接，获取请求协议。
 * 	02 返回响应协议
 * 	03 封装响应信息
 * 		内容可以动态添加
 * 		只关注状态码
 * 	04 封装请求信息
 * 	05 Request2 封装了获取参数的方法
 * 		
 * 
 * @author china
 *
 */
public class Server05 {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		Server05 server = new Server05();
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
			
			// ========= 获取请求协议 =========
			Request2 req = new Request2(client);
			// get reqInfo and print
			
			// =============== 返回 res ===============
			Response res = new Response(client);
			
			StringBuilder content = new StringBuilder();
			content.append("<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ 	"<title>来自服务器的消息</title>"
					+ "</head>"
					+ "<body>"
					+ 	"<h3>你好啊，"
					+ req.getParam("uname")
					+ "。欢迎来到我的世界！</h3>"
					+ "</body>"
					+ "</html>");
			// 关注了内容
			res.println(content.toString());
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
