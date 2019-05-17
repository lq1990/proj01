package com.wendao.net.tcp.chat.demo01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建server
 * @author china
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("--- server is running... ---");
		// 1. 
		ServerSocket server = new ServerSocket(8989);
		
		Socket socket = server.accept();
		
		// 接收数据
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String msg = dis.readUTF();
		System.out.println(msg);
		
		// 写出数据
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF("server: "+ msg);
		dos.flush();
		
	}
}
