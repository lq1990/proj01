package com.wendao.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * test OutputStream
 * @author china
 *
 */
public class IOTest05 {
	public static void main(String[] args) {
		// 1. src
		File dest = new File("dest.txt");
		
		// 2. stream
		OutputStream os = null;
		try {
			os = new FileOutputStream(dest);
			
			// 3. write, encode
			String msg = "to be written";
			byte[] datas = msg.getBytes();
			os.write(datas, 0, datas.length);
			os.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
