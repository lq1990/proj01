package com.wendao.net.tcp.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 浏览器也是一种client，应用层遵从http协议，其底层是tcp传输协议。
 * 
 * 1、 创建客户端。必须指定服务器端+端口。此时就在连接
 * 2、接收数据+发送数据
 * 
 * @author china
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		// 1. tcp是面向连接的，在创建client时，就已经在连接了
		Socket client = new Socket("localhost", 8888);
		// 2. 接收数据
		/*
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(client.getInputStream()));
		String echo = br.readLine(); // 阻塞式
		*/
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String echo = dis.readUTF();
		System.out.println(echo);
		
	}
}
