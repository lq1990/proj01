package com.wendao.httpserver01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * httpserver 练习01
 * 
 * Socket编程
 * 
 * 
 * @author china
 *
 */
public class Client {
	public static void main(String[] args) throws IOException {
		// 1. server
		ServerSocket server = new ServerSocket(8888);
		// 2. accept
		Socket client = server.accept();
		// 3. get info from client
		
		// 4. send msg to client
		
		
	}
}
