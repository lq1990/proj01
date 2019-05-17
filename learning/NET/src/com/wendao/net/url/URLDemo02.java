package com.wendao.net.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo02 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");// 主页 默认资源

		// 获取资源 网络流
		/*
		 * InputStream is = url.openStream(); byte[] flush = new byte[1024]; int len =
		 * 0; while ((len = is.read(flush))!=-1) { // System.out.println(len); String
		 * str = new String(flush, 0, len, "utf-8");// 此处设置charset也没用
		 * System.out.println(str); }
		 * 
		 * is.close();
		 */

		// 乱码。使用转换流
		BufferedReader br = new BufferedReader(
				new InputStreamReader(url.openStream(), "utf8")); // 设置解码charset
		// 使用文件流输出
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("dest1.html"), "utf8"));

		String msg = null;
		while ((msg = br.readLine()) != null) {
			System.out.println(msg);
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();

		bw.close();
		br.close();

	}
}
