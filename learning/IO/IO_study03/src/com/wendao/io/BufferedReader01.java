package com.wendao.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Buffered º”»Îª∫≥Â¡˜
 * FileReader, FileWriter
 * @author china
 *
 */
public class BufferedReader01 {
	public static void main(String[] args) {
		// 1. src
		File src = new File("abc.txt");
		
		// 2. stream
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(src)) ;
			
			// 3. operate
			String line = null;
			while((line = reader.readLine())!=null) {
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null!=reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
