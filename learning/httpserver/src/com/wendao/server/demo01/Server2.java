package com.wendao.server.demo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端：浏览器
 * 服务器自己写.
 * 
 * 用post时，from中name对应的内容不显示在query中。
 * 用br按行读取client发过来的信息，不显示name的内容。
 * 使用byte[]。
 * 此方法不太好，但先用着。
 * 
 * @author china
 *
 */
public class Server2 {
	private ServerSocket server;
	
	public static void main(String[] args){
	 	Server2 server = new Server2();
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
			
			byte[] data = new byte[20480]; // 用来接收client发过来的信息
			int len = client.getInputStream().read(data);
			
			// 接收client(browser)的请求信息
			String reqInfo = new String(data, 0, len).trim();
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











