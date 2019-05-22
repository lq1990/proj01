package com.sxt.io;

import java.io.File;

/**
 * File
 * .exist()
 * 	.isFile()
 * 	.isDirectory()
 * @author china
 *
 */
public class FileDemo04 {
	public static void main(String[] args) {
		File src = new File("D:\\myGithub\\myJava\\learning\\IO_study01\\src\\dog1.jpg");
		
		System.out.println(src.exists());
		System.out.println(src.isFile());
		System.out.println(src.isDirectory());
		
		// file status: standard code
		if (null == src || !src.exists()) {
			System.out.println("file is not found!");
		} else {
			if (src.isFile()) {
				System.out.println("file...");
			} else {
				System.out.println("dir...");
			}
		}
	}
}
