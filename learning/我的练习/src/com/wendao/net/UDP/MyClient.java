package com.wendao.net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * UDP
 * client
 * @author china
 *
 */
public class MyClient {
	public static void main(String[] args) throws IOException {
		System.out.println("client is running...");
		// 1. create
		DatagramSocket client = new DatagramSocket(6666);
		// 2. data to be sent
		String msg = "我爱学习";
		byte[] data = msg.getBytes();
		InetAddress addr = InetAddress.getLocalHost();
		DatagramPacket packet = new DatagramPacket(data, data.length, addr, 8888);
		// 3. 
		client.send(packet);
		// 4. 
		client.close();
		System.out.println("client closed.");
		
		
		
	}
}
