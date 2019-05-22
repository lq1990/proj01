package com.sxt.io;

import java.io.File;

/**
 * 
 * @author china
 *
 */
public class PathDemo01 {
	public static void main(String[] args) {
		String path = "D:\\myGithub\\myJava\\learning\\IO_study01\\src\\dog1.jpg"; // 转义
		
		System.out.println(File.separatorChar);
		System.out.println(File.separator);
		
		// ============= advises =================
		// 1. use / , not \
		path = "D:/myGithub/myJava/learning/IO_study01/src/dog1.jpg";
		// 2. 常量拼接
		path = "D:"+File.separator+"myGithub"+File.separator+"myJava"
				+File.separator+"learning"+File.separator+"IO_study01"
				+File.separator+"src"+File.separator+"dog1.jpg";
		
		System.out.println(path);
		
	}
}
