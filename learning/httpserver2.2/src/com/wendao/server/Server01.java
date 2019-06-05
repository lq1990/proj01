package com.wendao.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 	目标：
 * 	使用ServerSocket与client即browser连接，获取请求协议
 * 
 * 
 * @author china
 *
 */
public class Server01 {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		Server01 server = new Server01();
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
			
			// 获取请求协议
			InputStream is = client.getInputStream();
			// 在实际业务中，往往一行行读取或一个个字节读取。此处方便起见，一次性读
			byte[] datas = new byte[1024*1024]; // 1 MB，使用字节数组 接收
			int len = is.read(datas);
			
			// get reqInfo and print
			if (len>0) {
				String reqInfo = new String(datas, 0, len);
				System.out.println(reqInfo);
			} else {
				System.out.println("reqInfo is null");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
		
	}
	
	// 启动服务
	public void stop() {

	}
}
