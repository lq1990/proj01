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
public class IOTest01 {
	public static void main(String[] args) {
		// 1. create src
		File src = new File("abc.txt");
		
		// 2. select stream
		try {
			InputStream is = new FileInputStream(src);
			
			// 3. read or write
			int data1 = is.read(); // first data
			int data2 = is.read(); // second data
			int data3 = is.read(); 
			int data4 = is.read(); 
			System.out.println((char)data1);
			System.out.println((char)data2);
			System.out.println((char)data3);
			System.out.println(data4);
			
			// 4. free source
			is.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
