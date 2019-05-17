package com.wendao.net.tcp.socket;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <h1>
 * TCP.
 * <h1>
 * 必须先启动server，再用client连接
 * 
 * 接收多个client
 * 
 * @author china
 *
 */
public class MultiServer {
	public static void main(String[] args) throws IOException {
		System.out.println("--- TCP::server is running... ---");
		// 1. 
		ServerSocket server = new ServerSocket(8888); // http://localhost:8888 被监听
		// 2.
		int count = 0;
		while (true) {
			// 死循环，一个accept() 一个client
			
			Socket socket = server.accept(); // 阻塞式。此时只有请求
			System.out.println("server与一个client建立连接 "+(++count));
		
			// 3. send data
			String msg = "欢迎使用";
			// 输出流
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
			// dos.close() 不要运行，因为server不间断服务
			
		}
		
	}
}






