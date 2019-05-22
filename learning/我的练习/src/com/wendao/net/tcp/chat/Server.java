package com.wendao.net.tcp.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("--- Server is running... ---");
		// 1.
		ServerSocket server = new ServerSocket(9999);
		// 2. 
		Socket socket = server.accept();
		System.out.println("--- Server connects a client. ---");
		// 3. 
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF("from server: Welcome to my world.");
		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String msg = dis.readUTF();
		System.out.println(msg);
		
	}
}
