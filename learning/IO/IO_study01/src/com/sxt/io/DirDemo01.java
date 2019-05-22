package com.sxt.io;

import java.io.File;

/**
 * create dir
 * 1. mkdir()
 * 2. mkdirs()
 * 
 * @author lq
 *
 */
public class DirDemo01 {
	public static void main(String[] args) {
		File dir = new File("D:/myGithub/myJava/learning/IO_study01/dir/test");
		File dir2 = new File("D:/myGithub/myJava/learning/IO_study01/dir/test2");
		
		System.out.println(dir.mkdirs());
		System.out.println(dir2.mkdirs());
	}
}
