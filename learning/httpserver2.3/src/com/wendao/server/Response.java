package com.wendao.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * 对client的响应，提供接口 方便写 status code 和 正文。
 * 
 * @author china
 *
 */
public class Response {
	private final String BLANK = " ";
	private final String CRLF = "\r\n";

	private BufferedWriter bw;
	private StringBuilder headInfo; // res line and header
	private StringBuilder content; // res content, length for header
	private int len;// Content-Length

	public Response() {
		this.content = new StringBuilder();
		this.headInfo = new StringBuilder();
		this.len = 0;
	}

	public Response(Socket client) {
		this(); // overload of constructor
		try {
			this.bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			headInfo = null;
		}
	}

	public Response(OutputStream os) {
		this();
		this.bw = new BufferedWriter(new OutputStreamWriter(os));
	}

	// 动态添加内容
	public Response print(String info) {
		this.content.append(info);
		len = +info.getBytes().length;

		return this;
	}

	public Response println(String info) {
		this.content.append(info).append(CRLF);
		len = +(info + CRLF).getBytes().length; // CRLF 也占字节长度

		return this;
	}

	// 构建头信息
	private void createHeadInfo(int code) {
		// 1.1 res line
		headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
		switch (code) {
		case 200:
			headInfo.append("OK").append(CRLF);
			break;
		case 404:
			headInfo.append("NOT FOUND").append(CRLF);
			break;
		case 505:
			headInfo.append("SERVER ERROR").append(CRLF);
			break;
		}

		// 1.2 res header
		headInfo.append("Server:WD Server/0.0.1").append(CRLF).append("Date:" + new Date()).append(CRLF)
				.append("Content-Type:" + "text/html;charset=utf-8").append(CRLF).append("Content-Length:" + len)
				.append(CRLF);
		headInfo.append(CRLF);
	}

	// 推送响应信息
	public void pushToBrowser(int code) throws IOException {
		if (null == headInfo) {
			code = 505;
		}
		
		this.createHeadInfo(code);
		bw.append(headInfo);
		bw.append(content);
		bw.flush();
		// 此处把异常抛出到调用者，好处：外层可以传500code
	}

}




