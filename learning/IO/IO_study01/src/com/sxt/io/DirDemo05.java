package com.sxt.io;

import java.io.File;

/**
 * recursive print all subFiles and subDirs
 * count the size of folder
 * 
 * @author china
 *
 */
public class DirDemo05 {
	public static void main(String[] args) {
		File src = new File("D:/myGithub/myJava/learning/IO_study01");

		System.out.println(len);
		countSize(src);
		
		System.out.println(len);
	}
	
	private static long len = 0;
	
	public static void countSize(File src) {
		if (src != null && src.exists()) {
			if (src.isFile()) {
				len += src.length();
			} else {
				// descendant
				for(File s : src.listFiles()) {
					countSize(s);
				}
				
			}
		}
		
	}
}
