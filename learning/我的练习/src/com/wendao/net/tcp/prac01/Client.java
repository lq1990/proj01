package com.wendao.net.tcp.prac01;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		// 1. create
		Socket client = new Socket("localhost", 9999); // 面向连接，已经在连接了
		// 2. get data from server
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String data = dis.readUTF();
		System.out.println(data);
		
	}
}
