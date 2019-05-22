package com.wendao.server.demo03;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 封装req。 处理：来自于client的请求信息
 * 
 * @author china
 *
 */
public class Request {
	private String method; // 请求方式
	private String url; // 请求资源， ?之前的部分
	private Map<String, List<String>> paramsMapValues; 
	// ？之后的部分。 存请求参数。从界面上获取的都是String，需要什么格式再转。
	
	public static final String CRLF = "\r\n";
	private InputStream is;
	private String reqInfo;

	public Request() {
		this.method = "";
		this.url = "";
		this.paramsMapValues = new HashMap<String, List<String>>();
		this.reqInfo = "";
	}

	public Request(InputStream is) {
		this();
		this.is = is;
		try {
			byte[] buf = new byte[20480];
			int len = is.read(buf);
			this.reqInfo = new String(buf, 0, len);
			System.out.println(reqInfo);
		} catch (IOException e) {
			return;
		}

		// 分析 头信息
		parseReqInfo();

	}

	/**
	 * 分析请求信息 method, url, paramsMapValues
	 */
	private void parseReqInfo() {
		if (null == reqInfo || reqInfo.trim().equals("")) {
			return;
		}

		/**
		 * ===============================================
		 * 
		 * 1. 从信息的首行分解出：请求方式、请求路径、请求参数（可能存在） eg. GET /index.html?uname=anna&pwd=123
		 * HTTP/1.1
		 * 
		 * .若为POST方式，则请求参数在 最后的正文中
		 * 
		 * ===============================================
		 */
		String paramString = ""; // 请求参数，格式为 key=val&key2=val2&...

		// 1. 获取请求方式
		String firstLine = this.reqInfo.substring(0, reqInfo.indexOf(CRLF));
		int idx = reqInfo.indexOf("/");
		this.method = firstLine.substring(0, idx).trim();
		String urlStr = firstLine.substring(idx, firstLine.indexOf("HTTP/")).trim();
		if (this.method.equalsIgnoreCase("POST")) {
			this.url = urlStr;
			// POST请求的正文，在最后一段。
			paramString = this.reqInfo.substring(this.reqInfo.lastIndexOf(CRLF)).trim();

		} else if (this.method.equalsIgnoreCase("GET")) {
			// 考虑到参数可有可没有。先判断是否存在参数
			if (urlStr.contains("?")) {
				// 此时有参数
				String[] urlArr = urlStr.split("\\?"); // \\? 转义为 \?，表示?
				this.url = urlArr[0];
				paramString = urlArr[1]; // 接收请求参数
			} else {
				this.url = urlStr;
			}
		}

		// 2. 将请求参数封装到 Map中
		if (paramString.equals("")) {
			return;
		}

		this.parseParams(paramString);

	}

	/**
	 * 格式： uname=anna&pwd=123&fav=1
	 * 
	 * @param paramString
	 */
	private void parseParams(String paramString) {
		// 分割 将字符串转成数组
		StringTokenizer token = new StringTokenizer(paramString, "&");
		while (token.hasMoreTokens()) {
			String keyVal = token.nextToken();
			String[] kvs = keyVal.split("="); // [k, v]
			if (kvs.length == 1) {
				// 此时只有key，人为把val赋值为null
				kvs = Arrays.copyOf(kvs, 2);
				kvs[1] = null;
			}
			String key = kvs[0].trim();
			// ==== 注意：此处decode ==============
			String val = null==kvs[1] ? null : this.decode(kvs[1].trim(), "utf-8");
			// 转换成Map
			if (!paramsMapValues.containsKey(key)) {
				paramsMapValues.put(key, new ArrayList<String>());
			}
			List<String> vals = paramsMapValues.get(key);
			vals.add(val);
		}
		
//		System.out.println(paramsMapValues);
	}
	
	public String[] getParamVals(String key) {
		List<String> vals = null;
		if ((vals=this.paramsMapValues.get(key))==null) {
			return null;
		}else {
			return vals.toArray(new String[0]); 
			// 对于一个collection，若只含String，将它转成 array格式
		}
	}
	
	/**
	 * 根据页面的name，获取响应的值
	 * 
	 * @param args
	 */
	public String getParam(String key) {
		String[] vals = this.getParamVals(key);
		if (vals==null) {
			return null;
		}
		return vals[0];
	}

	/**
	 * 解决中文的问题。
	 * 因为中文显示在浏览器会乱码
	 * 
	 * @param value
	 * @param code
	 * @return
	 */
	private String decode(String value, String code) {
		try {
			return java.net.URLDecoder.decode(value, code);
		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
		}
		return null;
	}
	
	public String getURL() {
		return this.url;
	}
	
	/*
	public static void main(String[] args) {
		System.out.println("run...");
		String str = "uname=cello&pwd=123&fav=0&fav=1&fav=2";
		
		Request req = new Request();
		req.parseParams(str);

		System.out.println(req.getParam("uname"));
		System.out.println(req.getParam("pwd"));
		System.out.println(Arrays.toString(req.getParamVals("fav")));
		
	}
	*/

}










