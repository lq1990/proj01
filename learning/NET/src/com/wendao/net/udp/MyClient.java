package com.wendao.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 客户端
 * 1. 创建client + 端口
 * 2. 准备数据
 * 3. 打包（指定发送的地点、端口）
 * 4. 发送
 * 5. 释放资源
 * 
 * 服务器应先于客户端打开，否则server接收不到数据。
 * UDP 非面向连接，不安全。
 * 
 * @author china
 *
 */
public class MyClient {
	public static void main(String[] args) throws IOException {
		System.out.println("client main");
		// 1. create client
		DatagramSocket client = new DatagramSocket(6666);
		
		// 2. 准备数据
		String msg = "udp编程";
		byte[] data = msg.getBytes();
		
		// 3.打包，并指定发送的地点和端口
		DatagramPacket packet = new DatagramPacket(
				data, data.length, new InetSocketAddress("localhost", 8888));
		
		// 4. 
		client.send(packet);
		
		// 5.
		client.close();
		
	}
}








