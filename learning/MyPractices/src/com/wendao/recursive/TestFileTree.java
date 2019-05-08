package com.wendao.recursive;

import java.io.File;

/**
 * 
 * @author china
 *
 */
public class TestFileTree {
	public static void main(String[] args) {
		File file = new File("D:\\myGithub\\myJava\\learning\\collection");
		
//		for(File f : file.listFiles()) {
//			String fName = f.getName();
//			if(!fName.contains(".")){
//				System.out.println(f.getName());
//			}
//		}
		
		printFile(file, 0);
		
	}
	
	
	
	static void printFile(File file, int level) {
		for(int i=0;i<level;i++) {
			if(i==level-1) {
				System.out.print("-");
			}else {
				System.out.print(" ");
			}
		}
		
		System.out.println(file.getName());
		
		if(file.isDirectory()) {
			for(File fItem : file.listFiles()) {
				printFile(fItem, level+1);
			}
		}
	}
}
