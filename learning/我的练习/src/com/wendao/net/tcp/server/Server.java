package com.wendao.net.tcp.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Map;

/**
 * 手写httpserver。此为入口。 1. client为browser，html需要写 2. server为重点，涉及：
 * 处理来自client的request 写response
 * 
 * 细节： 对于不同的req，res不同 配置xml
 * 
 * @author china
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("server is running...\r\n--------------------------");
		// 1. ServerSocket
		ServerSocket server = new ServerSocket(8888);

		while (true) {
			// 2.
//			Socket socket = server.accept(); // accept一个client

			// req, res
			new Thread(new Dispatcher(server.accept())).start();

		}
	}
}
