package com.wendao.net.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyServer2 {
	public static void main(String[] args) throws IOException {
		System.out.println("server is running...");
		// 1. 
		DatagramSocket server = new DatagramSocket(7878);
		// 2. 
		byte[] container = new byte[1024];
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);
		// 3. 
		server.receive(packet);
		// 4. get data
		byte[] data = packet.getData();
		System.out.println(convert(data));
		// 5. 
		server.close();
		System.out.println("server closed.");
	}
	
	/**
	 * 字节数组 + Data输入流
	 * @param data
	 * @return
	 * @throws IOException 
	 */
	public static double convert(byte[] data) throws IOException {
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		double d = dis.readDouble();
		dis.close();
		
		return d;
	}
}
