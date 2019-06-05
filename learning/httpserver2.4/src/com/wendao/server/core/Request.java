package com.wendao.server.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装请求协议： 获取method，uri, param，请求参数 封装请求参数为Map
 * 
 * @author china
 *
 */
public class Request {
	private String reqInfo; // 协议信息
	private String method; // 请求方式
	private String url; // uri
	private String queryStr; // query String
	private Map<String, List<String>> paramsMap;

	public Request() {

	}

	public Request(Socket client) throws IOException {
		this(client.getInputStream());
	}

	public Request(InputStream is) {
		this.reqInfo = "";
		this.method = "";
		this.url = "";
		this.queryStr = "";
		this.paramsMap = new HashMap<String, List<String>>();

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
		this.url = this.reqInfo.
				substring(this.reqInfo.indexOf("/"), this.reqInfo.indexOf("HTTP/")).trim();

		if (this.method.equalsIgnoreCase("get")) {
			// ? 可能存在
			int queryIdx = this.reqInfo.indexOf("?");
			if (queryIdx >= 0) {
				// 有 ?
				String[] urlArr = this.url.split("\\?");
				// ? 需要转义，因为regexp中？有特别含义
				this.url = urlArr[0].trim();
				this.queryStr = urlArr[1].trim();
			}
		} else if (this.method.equalsIgnoreCase("post")) {
			this.queryStr = this.reqInfo.substring(this.reqInfo.lastIndexOf("\r\n")).trim();
		}

		System.out.println("url:" + url);
		System.out.println("queryStr:" + queryStr);

		// 有可能没有 query string
		if (null == queryStr || queryStr.equals("")) {
			return;
		}
		
		this.convertMap();
		System.out.println(this.paramsMap);

	}

	/**
	 * 处理请求参数为Map eg. fav=1&fav=2&uname=wendao&age=10&others=
	 */
	private void convertMap() {
		// 分割字符串
		String[] keyValues = this.queryStr.split("&");

		for (String keyValue : keyValues) {
			String[] kv = keyValue.split("=");
			kv = Arrays.copyOf(kv, 2); // 有了这个，即使val没有，也会赋值null，可避免index越界

			String key = kv[0].trim();
			String value = kv[1] == null ? "" : this.decode(kv[1].trim(), "UTF-8");
			// value中文乱码处理
			
			if (!paramsMap.containsKey(key)) {
				this.paramsMap.put(key, new ArrayList<String>());
			}
			this.paramsMap.get(key).add(value);
		}
	}
	
	/** 
	 * 处理中文
	 * 
	 * @param str
	 */
	private String decode(String str, String enc) {
		try {
			return java.net.URLDecoder.decode(str, enc);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 通过name获取form中对应的值
	 * 
	 * @param key
	 * @return
	 */
	public String[] getParams(String key) {
		List<String> values = this.paramsMap.get(key);
		if (null == values || values.size() < 1) {
			return null;
		}

		// 在项目中，通常返回 数组，而非 List。
		return values.toArray(new String[0]);
	}

	public String getParam(String key) {
		String[] values = this.getParams(key);
		return values == null ? null : values[0];
	}

	public String getMethod() {
		return method;
	}

	public String getUrl() {
		return url;
	}

	public String getQueryStr() {
		return queryStr;
	}

}
