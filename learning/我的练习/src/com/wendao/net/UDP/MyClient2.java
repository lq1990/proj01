package com.wendao.net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class MyClient2 {
	public static void main(String[] args) throws IOException {
		System.out.println("client is running...");
		// 1. create client
		DatagramSocket client = new DatagramSocket(6666);
		// 2. msg to be sent
		String msg = "what a happy life.";
		byte[] data = msg.getBytes();
		// 3. packet
		DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress(InetAddress.getLocalHost(), 8989));
		// 4. 
		client.send(packet);
		// 5. 
		client.close();
		
		System.out.println("clent closed.");
		
	}
}
