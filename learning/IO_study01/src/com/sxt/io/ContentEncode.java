package com.sxt.io;

import java.io.UnsupportedEncodingException;

/**
 * encode: char 2 byte
 * decode: byte 2 char
 * @author china
 *
 */
public class ContentEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "性命生命使命a"; // uft8 中文3字节编码，英文1字节
		// encode
		byte[] datas = msg.getBytes();
		System.out.println(datas.length);
		
		// encode: to other charset
		datas = msg.getBytes("UTF-16LE"); // 每个都是 2字节 编码
		System.out.println(datas.length);
		datas = msg.getBytes("GBK"); // 中文2字节，英文1字节
		System.out.println(datas.length);
		
		
	}
}
