package com.wendao.server.demo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端：浏览器
 * 服务器自己写
 * @author china
 *
 */
public class Server {
	private ServerSocket server;
	
	public static void main(String[] args){
	 	Server server = new Server();
	 	server.start();
	 	
	 	
	}
	
	/**
	 * 启动方法
	 */
	public void start() {
		try {
			server = new ServerSocket(9999);
			System.out.println("server is running...");

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
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(client.getInputStream()));
			// 用流的方式，把来自于client的信息接收，并储存在 sb 中
			while ((msg=br.readLine()).length() > 0  ) {
				sb.append(msg);
				sb.append("\r\n");
				
			}
			
			// 接收client(browser)的请求信息
			String reqInfo = sb.toString().trim();
			System.out.println(reqInfo);
			
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











