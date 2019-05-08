package com.wendao.myException;

import java.io.*;

public class TestReadFile {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println(openFile());

	}

	static String openFile() throws FileNotFoundException, IOException
	/* throws异常，谁调用此fn，谁来处理 */ {
		FileReader reader = new FileReader("D:\\myGithub\\a.txt");
		char c = (char) reader.read();
		return "" + c;

	}

	static String openFile0() {
		FileReader reader = null;

		try {
			reader = new java.io.FileReader("D:/myGithub/ab.txt");
			char c = (char) reader.read();
			char c2 = (char) reader.read();
			System.out.println("file content: " + c + c2);
			return "step1";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "step2";

		} catch (IOException e) {
			e.printStackTrace();
			return "step3";

		} finally {
			System.out.println("finally...");
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
