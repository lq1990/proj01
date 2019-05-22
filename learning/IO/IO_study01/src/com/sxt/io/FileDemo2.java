package com.sxt.io;

import java.io.File;

/**
 * absolute, relative path
 * absolute, D:
 * relative, no D:
 * @author lq
 *
 */
public class FileDemo2 {
	/**
	 * construct
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "D:/myGithub/myJava/learning/IO_study01/src/dog1.jpg";
		
		
		
		// absolute path
		File src = new File(path);
		System.out.println(src.getAbsolutePath());
		
		// relative path
		System.out.println(System.getProperty("user.dir"));
		src = new File("src/dog1.jpg");
		System.out.println(src.getAbsolutePath());
		System.out.println(src.length());
		
		System.out.println(src.separator);
		System.out.println(src.pathSeparator);
	}
}
