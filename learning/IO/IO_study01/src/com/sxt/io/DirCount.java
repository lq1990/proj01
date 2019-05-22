package com.sxt.io;

import java.io.File;

/**
 * recursive print all subFiles and subDirs
 * count the size of folder
 * use OOP
 * 
 * @author china
 *
 */
public class DirCount {
	
	private long len;
	
	private long fileNum;
	
	private long dirNum;
	
	private String path;
	
	private File src;
	
	public DirCount(String path) {
		this.path = path;
		this.src = new File(path);
		this.countSize(this.src);
	}
	
	public long length() {
		return len;
	}
	
	public long dirNum() {
		return dirNum;
	}
	
	public long fileNum() {
		return fileNum;
	}
	
	private void countSize(File src) {
		if (src != null && src.exists()) {
			if (src.isFile()) {
				len += src.length();
				fileNum++;
			} else {
				dirNum++;
				// descendant
				for(File s : src.listFiles()) {
					this.countSize(s);
				}
				
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		DirCount dir = new DirCount("D:/myGithub/myJava/learning/IO_study01");
		System.out.println(dir.length());
		System.out.println(dir.fileNum());
		System.out.println(dir.dirNum());
		
		DirCount dir2 = new DirCount("D:/myGithub/myJava/learning/PlaneGame");
		System.out.println(dir2.length());
		System.out.println(dir2.fileNum());
		System.out.println(dir2.dirNum());
	}
}














