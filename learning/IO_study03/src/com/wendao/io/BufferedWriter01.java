package com.wendao.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.Writer;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter
 * valid for pure text
 * @author china
 *
 */
public class BufferedWriter01 {
	public static void main(String[] args) {
		// 1. src
		File dest = new File("dest.txt");

		// 2. stream
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(dest)) ;

			// 3. write
			writer.append("well, study");
			writer.newLine();
			writer.append("我喜欢学习");
			
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != writer) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
