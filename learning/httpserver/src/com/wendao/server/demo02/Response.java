package com.wendao.server.demo02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * 封装响应信息。
 * 包括：
 * 第一行：协议，status code，描述。
 * 第二部分：header
 * 第三部分：content
 * 
 * @author china
 *
 */
public class Response {
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	
	private BufferedWriter bw;

	private StringBuilder content;

	private StringBuilder headerInfo; // 存储头信息

	private int len = 0; // 存储正文长度

	public Response() {
		this.headerInfo = new StringBuilder();
		this.content = new StringBuilder();
		len = 0;
	}
	
	public Response(OutputStream os) {
		this(); // 构造器的相互调用
		bw = new BufferedWriter(new OutputStreamWriter(os));
	}
	
	public Response(Socket socket) {
		this(); // 构造器的相互调用
		try {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			headerInfo = null;
		}
	}

	/**
	 * 构建正文
	 */
	public Response print(String info) {
		content.append(info);
		len += info.getBytes().length;
		return this;
	}

	/**
	 * 构建正文 + 回车
	 */
	public Response println(String info) {
		content.append(info).append(CRLF);
		len += (info + CRLF).getBytes().length;
		return this;
	}

	/**
	 * 构建响应头，
	 * 为了保证len准确，先构建content，再构建header
	 */
	private void createHeaderInfo(int code) {
		// 1. HTTP协议版本、状态码、描述
		headerInfo.append("HTTP/1.1" + BLANK).append(code).append(BLANK);
		switch (code) {
		case 200:
			headerInfo.append("OK");
			break;
		case 404:
			headerInfo.append("NOT FOUND");
			break;
		case 500:
			headerInfo.append("SERVER ERROR");
			break;

		default:
			break;
		}

		headerInfo.append(CRLF);
		// 2. 响应头
		headerInfo.append("Server:WENDAO Server/0.0.1").append(CRLF);
		headerInfo.append("Date:").append(new Date()).append(CRLF);
		headerInfo.append("Content-type:text/html;charset=utf-8").append(CRLF);
		headerInfo.append("Content-Length:").append(len).append(CRLF);
		headerInfo.append(CRLF); // 响应头 和 响应体 之间隔着一行

	}
	
	/**
	 * 推送到client
	 * @throws IOException 
	 */
	void pushToClient(int code) throws IOException {
		if (null == headerInfo) {
			code = 500;
		}
		
		// header + CRLF
		createHeaderInfo(code);
		this.bw.append(headerInfo.toString());
		
		// content
		bw.append(content.toString());
		bw.flush();
	}
	
	public void close() {
		CloseUtil.closeAll(bw);
	}
}








