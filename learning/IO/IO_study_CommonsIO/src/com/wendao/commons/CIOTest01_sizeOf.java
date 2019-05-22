package com.wendao.commons;

import java.io.File;

import org.apache.commons.io.FileUtils;

/**
 * 大小
 * 
 * @author china
 *
 */
public class CIOTest01_sizeOf {
	public static void main(String[] args) {
		// size of file
		long len = FileUtils.sizeOf(new File(
				"D:/myGithub/myJava/learning/IO_study_CommonsIO/src/com/wendao/commons/CIOTest01.java"));
		System.out.println(len);
		
		// size of folder
		
		len = FileUtils.sizeOf(
				new File("D:/myGithub/myJava/learning/IO_study_CommonsIO"));
		System.out.println(len);
		
		
	}
}
