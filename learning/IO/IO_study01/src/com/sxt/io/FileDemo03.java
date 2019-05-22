package com.sxt.io;

import java.io.File;

/**
 * name path
 * 
 * .getName()
 * .getPath()
 * .getAbsolutePath()
 * .getParent()
 * @author china
 *
 */
public class FileDemo03 {
	public static void main(String[] args) {
		File src = new File("D:\\myGithub\\myJava\\learning\\IO_study01\\src\\dog1.jpg");
		File src2 = new File("src/dog1.jpg");
		
		System.out.println("user.dir: "+System.getProperty("user.dir"));
		System.out.println("name: "+src.getName());
		System.out.println("path1: "+src.getPath());
		System.out.println("path2: "+src2.getPath());
		System.out.println("absolute path: "+src.getAbsolutePath());
		System.out.println("parent path: "+ src.getParent());
		System.out.println("parent obj: "+src.getParentFile().getName());
	}
}
