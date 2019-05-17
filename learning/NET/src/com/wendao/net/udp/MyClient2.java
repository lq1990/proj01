package com.wendao.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 要传输的数据是 double类型
 * @author china
 *
 */
public class MyClient2 {
	public static void main(String[] args) throws IOException {
		System.out.println("client is running...");
		// 1. 
		DatagramSocket client = new DatagramSocket();
		// 2. 
		double msg = 56.78;
		byte[] data = convert(msg);
		// 3. 
		DatagramPacket packet= 
				new DatagramPacket(data, data.length, 
						new InetSocketAddress(InetAddress.getLocalHost(), 7878));
		
		// 4.
		client.send(packet);
		// 5. 
		client.close();
		System.out.println("client closed.");
	}
	
	/**
	 * use ByteArrayOutputStream
	 * 
	 * double 2 byte[]
	 * 
	 * @param num
	 * @return
	 * @throws IOException 
	 */
	public static byte[] convert(double num) throws IOException {
		byte[] data = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeDouble(num);
		dos.flush();
		
		// get 
		data = baos.toByteArray();
		dos.close();
		
		return data;
	}
}
