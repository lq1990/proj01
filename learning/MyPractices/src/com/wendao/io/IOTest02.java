package com.wendao.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * my practices
 * @author china
 *
 */
public class IOTest02 {
	public static void main(String[] args) {
		// 1. src
		File src = new File("D:/myGithub/myJava/learning/MyPractices/src/com/wendao/io/test.txt");
		
		// 2. stream
		InputStream is = null;
		try {
			is = new FileInputStream(src);
			
			// 3. read/write
			int tmp;
			while((tmp=is.read())!=-1) {
				System.out.println((char)tmp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					// 4. free
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
