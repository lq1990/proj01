package com.wendao.net.tcp.prac01;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP传输协议下，server
 * 
 * @author china
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		// 1. 
		ServerSocket server = new ServerSocket(9999);
		// 2. 
		Socket socket = server.accept(); // blocks
		System.out.println("server connects a client...");
		
		// 3. send data to the client
		String msg = "Welcome to my world!";
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		
		
	}
}
