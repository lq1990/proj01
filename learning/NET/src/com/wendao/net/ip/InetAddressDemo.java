package com.wendao.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress 没有封装 端口
 * @author china
 *
 */
public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress()); // 134.169.236.36
		System.out.println(addr.getHostName()); // DESKTOP-R69CTMJ
		
		System.out.println();
		
		addr = InetAddress.getByName("www.163.com");
		System.out.println(addr.getHostAddress()); // 163.171.132.119
		System.out.println(addr.getHostName()); // www.163.com
		
		System.out.println();
		
		addr = InetAddress.getByName("134.169.236.36");
		System.out.println("host addr: "+addr.getHostAddress());
		System.out.println("host name: "+addr.getHostName());
	}
}
