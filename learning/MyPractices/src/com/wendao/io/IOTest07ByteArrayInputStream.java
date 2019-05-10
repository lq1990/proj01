package com.wendao.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * read buf-data into program
 * @author china
 *
 */
public class IOTest07ByteArrayInputStream {
	public static void main(String[] args) {
		// 1. src
		byte[] src = "src txt this is ...".getBytes();

		// 2. stream
		InputStream is = null;

		try {
			is = new ByteArrayInputStream(src); // src: buf

			// 3. read
			byte[] flush = new byte[50];
			int len = -1;
			while ((len = is.read(flush)) != -1) { // data into flush
				String str = new String(flush, 0, len);
				System.out.println(str);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
