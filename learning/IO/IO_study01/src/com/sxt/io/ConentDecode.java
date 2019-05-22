package com.sxt.io;

import java.io.UnsupportedEncodingException;

/**
 * decode: byte 2 char
 * @author china
 *
 */
public class ConentDecode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "性命生命使命a";
		// encode
		byte[] datas = msg.getBytes();
		
		// decode
		String msg1 = new String(datas, "utf8");
		System.out.println(msg1);
	
		// Mojibake 乱码
		// 1. bytes num 字节数 is not enough
		String msg2 = new String(datas,0, datas.length-2, "utf8");
		System.out.println(msg2);
		
		// 2. charset 字符集 it not identical
		String msg3 = new String(datas,0, datas.length-2, "gbk");
		System.out.println(msg3);
		
		
	}
	
}
