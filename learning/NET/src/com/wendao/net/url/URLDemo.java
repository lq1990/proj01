package com.wendao.net.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @author china
 *
 */
public class URLDemo {
	public static void main(String[] args) throws MalformedURLException {
		// 绝对路径构建
		URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=sxt");
		// #锚点：一个网页比较大时，用锚点快速定位
		System.out.println("协议："+			url.getProtocol());
		System.out.println("主机名 | 域名: "+url.getHost());
		System.out.println("端口："+			url.getPort());
		System.out.println("资源："+        url.getFile());
		System.out.println("相对路径："+		url.getPath());
		System.out.println("锚点："+    		url.getRef());
		System.out.println("参数："+			url.getQuery()); 
		// null, 因为若存在锚点，则参数为空
		
		System.out.println();
		
		// 相对路径构建
		url = new URL("http://www.baidu.com/a/");
		url = new URL(url, "b.txt");
		System.out.println(url.toString());
		
	}
}
