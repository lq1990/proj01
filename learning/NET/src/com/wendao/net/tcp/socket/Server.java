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
 * 1. 创建服务器 指定端口
 * 2. 接收client的连接，阻塞式（即：若接收不到，代码不往下执行）
 * 3. 发送数据+接收数据 
 * @author china
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("--- TCP::server is running... ---");
		// 1. 
		ServerSocket server = new ServerSocket(8888); // http://localhost:8888 被监听
		// 2.
		Socket socket = server.accept(); // 阻塞式。此时只有请求
		System.out.println("server与一个client建立连接");
		// 3. send data
		String msg = "欢迎使用";
		// 输出流
		/* 使用writer的话 麻烦
		BufferedWriter bw = 
				new BufferedWriter(
					new OutputStreamWriter(
							socket.getOutputStream()));
		
		bw.write(msg);
		bw.newLine();
		bw.flush();
		// 不要close bw，因为服务器不间断服务。
		*/
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
	
		
	}
}






