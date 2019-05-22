package com.wendao.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * @author china
 *
 */
public class CopyTxt {
	public static void main(String[] args) {
		copy("abc.txt", "dest2.txt");
	}
	
	
	public static void copy(String srcPath, String destPath) {
		// 1. src
		File src = new File(srcPath);
		File dest = new File(destPath);
		
		// 2. stream
		try(BufferedReader br = new BufferedReader(new FileReader(src));
				BufferedWriter bw = new BufferedWriter(new FileWriter(dest));){
			
			String line = null;
			while ((line=br.readLine())!=null) {
				bw.write(line);
				bw.newLine();
			}
			bw.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}
}
