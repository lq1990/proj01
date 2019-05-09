package com.wendao.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * my practise for IO
 * 
 * @author china
 *
 */
public class IOTest01 {
	public static void main(String[] args) {
		
		
		
		System.out.println("############");
		// 1. create src
		File src = new File("D:/myGithub/myJava/learning/MyPractices/src/com/wendao/io/test.txt");

		InputStream is = null;
		try {
			// 2. select stream
			is = new FileInputStream(src);

			// 3. read/write
			int tmp;
			while ((tmp = is.read()) != -1) {
				System.out.println((char) tmp);
			}
			


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != is) {
					// 4. free src
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
