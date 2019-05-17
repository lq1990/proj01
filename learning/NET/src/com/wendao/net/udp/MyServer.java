package com.wendao.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 先于client端 创建 server端。
 * 1. 创建服务端 + 端口
 * 2. 准备接收容器
 * 3. 封装成包
 * 4. 接收数据
 * 5. 分析数据
 * 
 * @author china
 *
 */
public class MyServer {
	
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("server main");
		// 1. create server
		DatagramSocket server = new DatagramSocket(8888);
		
		// 2. prepare a container
		byte[] container = new byte[1024];
		
		// 3. encapsulate
		DatagramPacket packet = new DatagramPacket(container, container.length);
		
		// 4. receive data
		server.receive(packet);
		
		// 5. analyse data
		byte[] data = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(data, 0, len));
		System.out.println("len: "+len);
		
		// 6. free
		server.close();
		
		
	}
}
