package com.wendao.commons;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * 列出子孙集
 * @author china
 *
 */
public class CIOTest02_listFiles {
	public static void main(String[] args) {
		// 默认操作一层
		Collection<File> files = FileUtils.listFiles(
				new File("D:/myGithub/myJava/learning/IO_study_CommonsIO"), 
				EmptyFileFilter.NOT_EMPTY, null);
		
		for(File f : files) {
			System.out.println(f.getAbsolutePath());
		}
		
		//
		System.out.println("-----------------");
		// 操作子孙集
		files = FileUtils.listFiles(
				new File("D:/myGithub/myJava/learning/IO_study_CommonsIO"), 
				new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
		
		for(File f : files) {
			System.out.println(f.getAbsolutePath());
		}
		
		System.out.println("-----------------");
		// 操作子孙集
		files = FileUtils.listFiles(
				new File("D:/myGithub/myJava/learning/IO_study_CommonsIO"), 
				FileFilterUtils.or(new SuffixFileFilter("java"), 
							new SuffixFileFilter("class")), 
				DirectoryFileFilter.INSTANCE);
		
		for(File f : files) {
			System.out.println(f.getAbsolutePath());
		}
		
		System.out.println("-----------------");
		// 操作子孙集
		files = FileUtils.listFiles(
				new File("D:/myGithub/myJava/learning/IO_study_CommonsIO"), 
				FileFilterUtils.and(new SuffixFileFilter("java"), 
						EmptyFileFilter.NOT_EMPTY), 
				DirectoryFileFilter.INSTANCE);
		
		for(File f : files) {
			System.out.println(f.getAbsolutePath());
		}
		
		
	}
}
