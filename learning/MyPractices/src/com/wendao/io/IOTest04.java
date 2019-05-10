package com.wendao.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * test InputStream
 * @author china
 *
 */
public class IOTest04 {
	public static void main(String[] args) {
		// 1. src
		File src = new File("D:/myGithub/myJava/learning/MyPractices/src/com/wendao/io/test.txt");
		
		// 2. strean
		InputStream is = null;
		try {
			is = new FileInputStream(src);
			
			// 3. read, decode
			int tmp;
			while((tmp = is.read())!=-1) {
				System.out.println((char)tmp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null!=is) {
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
