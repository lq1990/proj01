package com.sxt.io;

import java.io.File;

/**
 * 
 * @author lq
 *
 */
public class FileDemo01 {
	/**
	 * construct
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "D:/myGithub/myJava/learning/IO_study01/src/dog1.jpg";
		
		// 1. construct a obj
		File src = new File(path);
		System.out.println(src.length()); // size of file
		
		// 2. 
		src = new File("D:/myGithub/myJava/learning/IO_study01/src", "dog1.jpg");
		System.out.println(src.length());
		
		// 3. 
		src = new File(new File("D:/myGithub/myJava/learning/IO_study01/src"), "dog1.jpg");
		System.out.println(src.length());
	}
}
