package com.wendao.net.tcp.prac03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * HTTP Server
 * @author china
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("--- server is running ---");
		// 1. 
		ServerSocket server = new ServerSocket(8888);
		// 2. 
		Socket socket = server.accept(); // accept一次，就连接了一个client
		// 3.1. get info from a client
		byte[] buf = new byte[10240];
		int len = socket.getInputStream().read(buf);
		System.out.println(new String(buf, 0, len));
		
		// 3.2 write msg to client。注意响应文格式
		
		
		
	}
}
