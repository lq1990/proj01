package com.wendao.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * OutputStream, FileOutputStream
 * @author china
 *
 */
public class IOTest06 {
	public static void main(String[] args) {
		// 1. src
		File dest = new File("dest.txt");
		
		// 2. stream
		OutputStream os = null;
		
		try {
			os = new FileOutputStream(dest, true);
			
			// 3. write, encode
			String msg = "this is a message";
			byte[] datas = msg.getBytes();
			os.write(datas);
			
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
