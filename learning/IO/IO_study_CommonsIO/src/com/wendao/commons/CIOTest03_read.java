package com.wendao.commons;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * 读取内容
 * @author china
 *
 */
public class CIOTest03_read {
	public static void main(String[] args) throws IOException {
		File file = new File("tmp.txt");
		
		// read a file
		String msg = FileUtils.readFileToString(file, "UTF-8");
		System.out.println(msg);
		
		byte[] datas = FileUtils.readFileToByteArray(file);
		
		System.out.println(datas.length);
		
		System.out.println("##############33");
		// read line by line
		List<String> msgs = FileUtils.readLines(file, "UTF-8");
		System.out.println(msgs);
		System.out.println("##########");
		
		LineIterator it = FileUtils.lineIterator(file, "UTF-8");
		while(it.hasNext()) {
			System.out.println(it.nextLine());
		}
		
	}
}















