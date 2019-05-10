package com.wendao.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * program -> buf
 * 
 * @author china
 *
 */
public class IOTest08ByteArrayOutputStream {
	public static void main(String[] args) {
		// 1. dest
		byte[] dest = null;
		
		// 2. stream
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			
			String msg = "message...";
			byte[] datas = msg.getBytes();
			// 3. write
			baos.write(datas, 0, datas.length);
			baos.flush();
			
			// get 
			dest = baos.toByteArray();
			System.out.println(new String(dest, 0, baos.size()));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
