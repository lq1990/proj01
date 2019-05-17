package com.wendao.net.tcp.chat.demo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建server
 * 
 * @author china
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("--- server is running... ---");
		// 1.
		ServerSocket server = new ServerSocket(8989);

		
		Socket socket = server.accept(); // 一个accept一个client
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

		while (true) {
			// 接收数据
			String msg = dis.readUTF();
			System.out.println("server gets msg: "+msg);

			// 写出数据
			dos.writeUTF("server repeats: " + msg); dos.flush();

		}

	}
}
