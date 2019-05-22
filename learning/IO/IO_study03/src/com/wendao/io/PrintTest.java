package com.wendao.io;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 打印流 PrintStream
 * @author china
 *
 */
public class PrintTest {
	public static void main(String[] args) throws FileNotFoundException {
		// System.out
		PrintStream ps = System.out;
		ps.println("print stream");
		ps.println(true);
		
		ps = new PrintStream(
				new BufferedOutputStream(
					new FileOutputStream("print.txt")),
				true); // auto flush
		
		ps.println("print stream.............");
		ps.println(false);
		ps.close();
		
		// 重定向 输出流
		System.setOut(ps);
		System.out.println("change");
		
		// 重定向 回控制台
		System.setOut(new PrintStream(
						new BufferedOutputStream(
							new FileOutputStream(FileDescriptor.out)),
						true));
		System.out.println("haha");
		
		
	}
}








