package com.wendaochupin.io;

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
public class IOTest06FileWriter {
	public static void main(String[] args) {
		// 1. src
		File dest = new File("dest.txt");

		// 2. stream
		Writer writer = null;
		try {
			writer = new FileWriter(dest);

			// 3. write
			String msg = "this is msg: for you...\r\n学习";
			
			// 3.1
//			char[] datas = msg.toCharArray(); // str 2 char[]
//			writer.write(datas, 0, datas.length);
			
			// 3.2
			writer.write(msg);
			
			// 3.3 append
			writer.append("this is msg: for you...\r\n").append("学习啊");
			
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
