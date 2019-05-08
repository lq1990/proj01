package com.wendao.myException;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *  ÷∂Ø throw
 * @author china
 *
 */
public class TestThrow {
	public static void main(String[] args) {
		File f = new File("d:/myGithub/aa.txt");
		
		if(!f.exists()) {
			try {
				throw new FileNotFoundException("file not found!");
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(f.getName());
		}
		
	}
}
