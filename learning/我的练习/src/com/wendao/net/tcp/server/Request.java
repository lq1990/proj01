package com.wendao.net.tcp.server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Request {
	private String reqInfo = "";
	private String method = "";
	private String url = "";
	private Map<String, String> paramsMap;
	private String uname = "";
	private String pwd = "";

	/**
	 * 
	 * @param socket
	 * @throws IOException
	 */
	public Request(Socket socket) {
		super();

		// 拿到来自client的info
		byte[] buf = new byte[102400];
		int len;
		try {
			len = socket.getInputStream().read(buf);
			System.out.println("len: "+len);
			if (len<0) {
				return;
			}
			String reqInfo = new String(buf, 0, len);
			this.reqInfo = reqInfo;
			this.paramsMap = new HashMap<String, String>();

			System.out.println(reqInfo);
			// 解析

		} catch (IOException e) {
			return;
		}
		this.parse();

	}

	private void parse() {
		this.method = this.reqInfo.substring(0, this.reqInfo.indexOf("/")).trim();
		System.out.println("parse::method: " + this.method);
		
		String paramsStr = "";
		if (this.method.equalsIgnoreCase("GET")) {
			String firstLine = this.reqInfo.substring(0, this.reqInfo.indexOf("\r\n"));
			if (!firstLine.contains("?")) {
				this.url = this.reqInfo.substring(this.reqInfo.indexOf("/"), this.reqInfo.indexOf("HTTP/")).trim();
			} else {
				this.url = this.reqInfo.substring(this.reqInfo.indexOf("/"), this.reqInfo.indexOf("?")).trim();
				paramsStr = this.reqInfo.substring(this.reqInfo.indexOf("?") + 1, this.reqInfo.indexOf("HTTP/")).trim();
			}
		} else if (this.method.equalsIgnoreCase("POST")) {
			this.url = this.reqInfo.substring(this.reqInfo.indexOf("/"), this.reqInfo.indexOf("HTTP/")).trim();
			paramsStr = this.reqInfo.substring(this.reqInfo.lastIndexOf("\r\n")).trim();

		}
		if (paramsStr == "") {
			return;
		}
		String[] params = paramsStr.split("&");
		for (String s : params) {
			String[] kvs = s.split("=");
			String key = kvs[0].trim();
			String value = this.decode(kvs[1].trim()); // decode
			this.paramsMap.put(key, value);
		}

//		System.out.println(method);
//		System.out.println(url);
//		System.out.println(paramsStr);
		String uname_raw = this.paramsMap.get("uname");
		String uname = "";
		try {
			this.uname = java.net.URLDecoder.decode(uname_raw, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.pwd = this.paramsMap.get("pwd");
//		System.out.println(uname);
//		System.out.println(pwd);

	}

	public String getURL() {
		return this.url;
	}

	public Map<String, String> getPramsMap() {
		return this.paramsMap;
	}

	private String decode(String str) {
		try {
			return java.net.URLDecoder.decode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

}
