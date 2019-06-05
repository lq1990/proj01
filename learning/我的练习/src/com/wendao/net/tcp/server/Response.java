package com.wendao.net.tcp.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Date;
import java.util.Map;

public class Response {
	private Socket socket;
	private Map<String, String> paramsMap;

	/**
	 * @param socket
	 */
	public Response(Socket socket, Map<String, String> paramsMap) {
		super();
		this.socket = socket;
		this.paramsMap = paramsMap;
	}

	public void sendToClient(int code) throws UnsupportedEncodingException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));

		StringBuilder res = new StringBuilder();
		// res first line
		String resFirstLine = "HTTP/1.1 " + code + "OK" + "\r\n";
		// res content
		String name = "";
		if (null != paramsMap) {
			name = paramsMap.get("uname");
		} 
		String resContent = "<html><head>" + "<title>来自服务器的响应</title>" + "</head><body>" + "你好，" + name + "。欢迎来到我的世界！"
				+ "</body></html>";
		// res header
		StringBuilder resHeader = new StringBuilder();
		resHeader.append("Server: Tomcat WD/0.0.1").append("\r\n");
		resHeader.append("Date:" + new Date()).append("\r\n");
		resHeader.append("Content-Type:text/html;charset=\"utf-8\"").append("\r\n"); // Content-Type html设置charset
		resHeader.append("Content-Length:" + resContent.getBytes().length).append("\r\n"); // Content-Type为字节数组长度

		res.append(resFirstLine);
		res.append(resHeader);
		res.append("\r\n");
		res.append(resContent);

		bw.write(res.toString());
		bw.flush();

	}
}
