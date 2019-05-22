package com.wendao.net.tcp.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("client is running...");
		// 1. 
		Socket client = new Socket("localhost", 9999); // 已经尝试连接
		// 2. data send/get
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String msg = console.readLine();
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("from client: "+msg);
		dos.flush();
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
	}
}
