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
 * 目标： 01 使用ServerSocket与client即browser连接，获取 req 协议。 02 返回 res 协议 03 封装 res 信息
 * 内容可以动态添加 只关注状态码 04 封装 req 信息 05 Request 封装了获取参数的方法 06 servlet 的使用，解耦了业务代码 07
 * xml配置文件，反射，利于后续扩展。代替if/else 08 dispatcher, multi-thread
 * 
 * 
 * @author china
 *
 */
public class Server08 {
	private boolean isRunning; // 可停止多线程运行，外部也可以操作它
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server08 server = new Server08();
		server.start();

	}

	// 启动服务
	public void start() {
		try {
			this.serverSocket = new ServerSocket(8888);
			System.out.println("server is running...");
			this.isRunning = true;

			this.receive(); // receive clients after starting
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
			this.stop();
		}
	}

	// 接受连接处理
	public void receive() {
		try {
			while (this.isRunning) {
				// One Client, One Thread
				
				Socket client = this.serverSocket.accept(); // accept a client
				System.out.println("一个client建立了连接");
				// multi-thread
				new Thread(new Dispatcher(client)).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}

	}

	// 启动服务。外部可以调用
	public void stop() {
		this.isRunning = false;
		try {
			this.serverSocket.close();
			System.out.println("server stopped");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
