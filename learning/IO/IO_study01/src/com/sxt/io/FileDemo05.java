package com.sxt.io;

import java.io.File;
import java.io.IOException;

/**
 * .length()
 * .createNewFile()
 * .delete()
 * @author china
 *
 */
public class FileDemo05 {
	public static void main(String[] args) {
		File src = new File("D:/myGithub/myJava/learning/IO_study01/src/dog1.jpg");
		File d1 = new File("D:/myGithub/myJava/learning/IO_study01");
		System.out.println(src.length());
		System.out.println(d1.length()); // length of dir = 0
		
		src = new File("D:/myGithub/myJava/learning/IO_study01/src/aa/");
		try {
			boolean flag = src.createNewFile();
			System.out.println(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(src.delete());
	}
}
