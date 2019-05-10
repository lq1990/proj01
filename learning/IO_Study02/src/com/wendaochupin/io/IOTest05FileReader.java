package com.wendaochupin.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * FileReader, FileWriter
 * @author china
 *
 */
public class IOTest05FileReader {
	public static void main(String[] args) {
		// 1. src
		File src = new File("abc.txt");
		
		// 2. stream
		Reader reader = null;
		try {
			reader = new FileReader(src);
			
			// 3. operate
			char[] flush = new char[1024];
			int len = -1;
			while((len=reader.read(flush))!=-1) {
				String str = new String(flush);
				System.out.println(str);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null!=reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
