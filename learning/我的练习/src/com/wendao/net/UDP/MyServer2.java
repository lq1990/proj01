package com.wendao.net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MyServer2 {
	public static void main(String[] args) throws IOException {
		System.out.println("server is running...");
		// 1. create
		DatagramSocket server = new DatagramSocket(8989);
		// 2. container
		byte[] container = new byte[1];
		// 3. packet
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);
		// 4. receive 
		server.receive(packet);
		// 5. analyse
		byte[] data = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(data,0,len,"utf8"));
		// 6. free
		server.close();
		System.out.println("server closed.");
		
	}
}
