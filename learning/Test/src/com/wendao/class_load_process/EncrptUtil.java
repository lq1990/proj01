package com.wendao.class_load_process;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EncrptUtil {
	
	public static void main(String[] args) {
		String src = "D:\\myGithub\\myJava\\learning\\Test\\src\\HelloWorld.class";
		String dest = "D:\\myGithub\\myJava\\learning\\Test\\src\\tmp\\HelloWorld.class";
		// 注意：class文件名必须与 类名一致
		encrypt(src, dest);
	}
	
	
	public static void encrypt(String src, String dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			int tmp = -1;
			while((tmp = fis.read()) != -1) { // read a byte of data from is
				fos.write(tmp^0xff); // NOT bitwise operation, to encrypt
			}
		
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if (null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
}











