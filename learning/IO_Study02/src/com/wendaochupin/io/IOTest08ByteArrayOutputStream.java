package com.wendaochupin.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ByteArray
 * 1. dest: no need to self-def
 * 2. not parent class
 * 
 * 4. no need to free src
 * 
 * 
 * get datas, by .toByteArray()
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
			
			// 3. write
			String msg = "show me the code";
			byte[] datas = msg.getBytes();
			
			baos.write(datas, 0, datas.length);
			baos.flush();
			
			// get datas
			dest = baos.toByteArray();
			System.out.println(new String(dest, 0, baos.size()));
			System.out.println(baos.size());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
