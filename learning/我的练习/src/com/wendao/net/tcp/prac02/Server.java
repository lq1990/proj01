package com.wendao.net.tcp.prac02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Client: Browser
 * Server: diy
 * 
 * @author china
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("--- server is running ---");
		// 1. 
		ServerSocket server = new ServerSocket(8888);
		// 2. 
		Socket socket = server.accept();
		System.out.println("server connects a client\r\n");
		// 3. dis, receive info from client
//		DataInputStream dis = new DataInputStream(socket.getInputStream());
//		System.out.println(dis.readUTF());
		// 3. br, receive info from client
//		BufferedReader br = 
//				new BufferedReader(new InputStreamReader(socket.getInputStream()));
//		String msg = null;
//		while ((msg=br.readLine())!=null) {
//			System.out.println(msg);
//		}
		// 3. byte[], get info from client
		byte[] buf = new byte[20480];
		int len = socket.getInputStream().read(buf);
		System.out.println(new String(buf, 0, len).trim());

		
		// 4. send msg to client
		StringBuilder res = new StringBuilder();
		StringBuilder resHeader = new StringBuilder();
		// 4.1 HTTP/1.1 200 Ok
		res.append("HTTP/1.1 200 OK").append("\r\n");
		// 4.3 res content
		String con = 
				"<html><head><title>title</title></head><body>I am body.</body></html>";
		// 4.2 res header
		resHeader.append("Server:WD Tomcat/1.1.1").append("\r\n");
		resHeader.append("Date:"+new Date().toString()).append("\r\n");
		resHeader.append("Content-Type:"+"text/html;charset=UTF-8").append("\r\n");
		resHeader.append("Content-Length:"+con.getBytes().length).append("\r\n"); // 字节数
		res.append(resHeader).append("\r\n").append(con);
		
		BufferedWriter bw = 
				new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bw.write(res.toString());
		bw.flush();
		
		// 响应格式的3部分，一定要格式正确。
		// CRLF即\r\n 一定加。响应头和响应正文之间另有一CRLF
		
	}
}










