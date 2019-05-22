package com.wendaochupin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 1. 创建源
 * 2. 选择流
 * 3. 操作
 * 4. 释放资源
 * 
 * @author china
 *
 */
public class IOTest02 {
	public static void main(String[] args) {
		// 1. create src
		File src = new File("abc.txt");
		
		// 2. select stream
		InputStream is = null;
		try {
			is = new FileInputStream(src);
			
			// 3. read or write
			int temp;
			while((temp = is.read()) != -1 ) {
				System.out.println((char)temp);
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
