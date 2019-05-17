package com.wendao.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 包含端口
 * @author china
 *
 */
public class InetSocketAddressDemo {
	public static void main(String[] args) {
		InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 9999);
		System.out.println(addr.getHostName());
		System.out.println(addr.getPort());
		
		System.out.println();
		
		InetAddress add = addr.getAddress();
		System.out.println(add.getHostAddress());
		System.out.println(add.getHostName());
		
	}
}
