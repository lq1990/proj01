package com.sxt.io;

import java.io.File;

/**
 * recursive print all subFiles and subDirs
 * 
 * @author china
 *
 */
public class DirDemo04 {
	public static void main(String[] args) {
		File src = new File("D:/myGithub/myJava/learning/IO_study01");

		printName(src, 0);
	}

	public static void printName(File src, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("-");
		}
		System.out.println(src.getName());

		if (null == src || !src.exists()) {
			return;
		} else if (src.isDirectory()) {
			for (File s : src.listFiles()) {
				printName(s, level+1);
			}
		}

	}
}
