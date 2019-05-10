package com.wendao.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * steps: 文件字节输出�? 1. src 2. stream 3. read/write 4. free
 * 
 * @author china
 *
 */
public class BufferedOutputStream02 {
	public static void main(String[] args) {
		// 1. src
		File dest = new File("dest11.txt");

		// 2. steam
		OutputStream os = null;

		try {
			os = new BufferedOutputStream(new FileOutputStream(dest, true));  
					// second para: if append
			
			// 3. write
			String msg = "IO is so easy69\r\n";
			byte[] datas = msg.getBytes(); // char 2 byte, encode
			os.write(datas, 0, datas.length);
			os.flush(); // refresh, save buffered data
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != os) {
				// 4. free
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
