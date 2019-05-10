package com.wendao.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流 InputStreamReader OutputStreamWriter 
 * 1. 以字符流的形式 操作 字节流 （纯文本而言）
 * 
 * 2. 指定字符集
 * 
 * @author china
 *
 */
public class ConvertTest {
	public static void main(String[] args) {
		System.out.println("begin...");
		// System.in, .out
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));) {
			// loop 
			
			String msg = "";
			while (!msg.equals("exit")) {
				// read
				msg = reader.readLine();
				
				// write
				writer.write(msg);
				writer.newLine();
				writer.flush(); // dont forget
			}
			
			
		} catch (IOException e) {
			System.out.println("异常");
			e.printStackTrace();
		}

	}
}
