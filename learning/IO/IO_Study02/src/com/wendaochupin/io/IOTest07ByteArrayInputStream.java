package com.wendaochupin.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ByteArray
 * 1. src: byte[] not so big
 * 2. no need to free src
 * 
 * @author china
 *
 */
public class IOTest07ByteArrayInputStream {
	public static void main(String[] args) {
		// 1. src
		byte[] src = "well, i like study".getBytes();
		
		// 2. stream
		InputStream is = null;
		try {
			is = new ByteArrayInputStream(src);
			byte[] flush = new byte[5];
			int len=-1;
			while((len = is.read(flush))!=-1) {
				String str = new String(flush, 0, len);
				System.out.print(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
