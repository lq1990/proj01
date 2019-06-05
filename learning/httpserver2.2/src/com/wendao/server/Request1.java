package com.wendao.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 封装请求协议： 获取method，uri，请求参数
 * 
 * @author china
 *
 */
public class Request1 {
	private String reqInfo; // 协议信息
	private String method; // 请求方式
	private String url; // uri
	private String queryStr; // query String

	public Request1() {

	}

	public Request1(Socket client) throws IOException {
		this(client.getInputStream());
	}

	public Request1(InputStream is) {
		// 在实际业务中，往往一行行读取或一个个字节读取。此处方便起见，一次性读
		byte[] datas = new byte[1024 * 1024]; // 1 MB，使用字节数组 接收
		int len;

		try {
			len = is.read(datas);
			
			if (len > 0) {
				// get reqInfo and print
				reqInfo = new String(datas, 0, len);

			} else {
				System.out.println("reqInfo is null");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// 分解字符串
		this.parseReqInfo();
	}

	private void parseReqInfo() {
		System.out.println("--- 分解字符串开始 ---");
		System.out.println(reqInfo);
		System.out.println("+++ 1. method +++");
		this.method = this.reqInfo.substring(0, this.reqInfo.indexOf("/")).trim().toLowerCase();
		System.out.println(method);
		System.out.println("+++ 2. url +++");
		this.url = this.reqInfo.substring(
					this.reqInfo.indexOf("/"), this.reqInfo.indexOf("HTTP/"));
		// ? 可能存在
		int queryIdx = this.reqInfo.indexOf("?");
		if (queryIdx >= 0) {
			// 有 ?
			String[] urlArr = this.url.split("\\?");
			this.url = urlArr[0];
			this.queryStr = urlArr[1];
		}
		System.out.println(url);
		
	}
}











