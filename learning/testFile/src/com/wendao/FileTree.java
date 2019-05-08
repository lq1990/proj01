package com.wendao;

import java.io.File;

/**
 * 打印目录树状结构，使用递归算法
 * @author china
 *
 */
public class FileTree {
	public static void main(String[] args) {
		File f = new File("D:\\myGithub\\myJava\\learning\\testFile");
		printFile(f, 0);
	}
	
	static void printFile(File file, int level) {
		for(int i=0;i<level;i++) {
			System.out.print("-");
		}
		System.out.println(file.getName());
		
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File tmp : files) {
				printFile(tmp, level+1);
			}
		} 
		
	}
}
