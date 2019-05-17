package com.wendao.net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP传输协议。
 * 服务器端
 * @author china
 *
 */
public class MyServer {
	public static void main(String[] args) throws IOException {
		System.out.println("server is running...");
		
		// 1. create server
		DatagramSocket server = new DatagramSocket(8888);
		// 2. prepare container
		byte[] container = new byte[2014];
		// 3. packet
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);
		// 4. receive data from client, into packet
		server.receive(packet);
		// 5. analyse
		byte[] data = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(data, 0, len, "utf8"));
		
		// 6. free
		server.close();
		System.out.println("server closed.");
		
		
	}
}
