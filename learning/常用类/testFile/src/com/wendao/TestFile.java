package com.wendao;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author china
 *
 */
public class TestFile {
	public static void main(String[] args) {
		File f = new File("D:\\myGithub\\myJava\\test.java"); // file
		File f2 = new File("D:/myGithub/myJava"); // dir
		File f3 = new File(f2, "test.java");
		File f4 = new File(f2, "newFile2.java");
		File f5 = new File("D:\\myGithub\\myJava\\aa\\bb\\cc\\dd");
		File f52 = new File("D:\\myGithub\\myJava\\dd");
		
		f5.mkdirs();
		
//		f4.delete();
		
		System.out.println(f.exists());
		System.out.println(f3.exists());
		
		if(f.isFile()) {
			System.out.println("f is file");
		}
		if (f2.isDirectory()) {
			System.out.println("f is dir");
		}
		
		System.out.println(f.length());
	}
}
