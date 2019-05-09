package com.wendaochupin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * steps:
 * 1. src
 * 2. stream
 * 3. read/write
 * 4. free
 * 
 * @author china
 *
 */
public class IOTest3 {
	public static void main(String[] args) {
		// 1. create src
		File src = new File("abc.txt");
		
		// 2. select stream
		InputStream is = null;
		try {
			is = new FileInputStream(src);
			
			// 3. read or write
			byte[] flush = new byte[1024*10]; // 3 byte each time, size of buffer
			int len = -1; // length of bytes that is returned
			while((len = is.read(flush)) != -1 ) {
				// byte[] to char (decode)
				String str = new String(flush, 0, len); // from idx=0, length = len
				System.out.print(str);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. free source
			try {
				if (null != is) { // avoid voidPointer Exception
					is.close();
				}
					
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}
