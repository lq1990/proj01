package com.sxt.io;

import java.io.File;

/**
 * 
 * list()
 * listFiles()
 * listRoot()
 * @author lq
 *
 */
public class DirDemo02 {
	public static void main(String[] args) {
		File dir = new File("D:/myGithub/myJava/learning/IO_study01");
		
		
		// list names
		String[] subNames = dir.list();
		for(String t : subNames) {
			System.out.println(t);
		}
		
		// list objs
		File[] subFiles = dir.listFiles();
		for(File f : subFiles) {
			System.out.println(f);
		}
		
		System.out.println("-------------------");
		
		// listRoot()
		File[] roots = dir.listRoots();
		for(File f : roots) {
			System.out.println(f); // C:\ 	D:\
		}
	}
}
