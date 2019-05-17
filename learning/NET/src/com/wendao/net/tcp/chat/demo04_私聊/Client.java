package com.wendao.net.tcp.chat.demo04_私聊;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建client，发送、接收数据
 * 
 * 写出数据：输出流 读取数据：输入流
 * 
 * 当前问题：输出流和输入流 在同一条路径下，有先后之分。
 * 应该是 输入和输出独立
 * 
 * 实现私聊：加入名称
 * 
 * @author china
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("client is running...");
		
		System.out.println("请输入昵称：");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		if (name.equals("")) {
			return;
		}
		
		// 1.
		Socket client = new Socket("localhost", 8989); // 已经开始连接
		
		// 控制台输入流
		new Thread(new Send(client, name)).start(); // 一条路径

		new Thread(new Receive(client)).start();
		
	}
}
