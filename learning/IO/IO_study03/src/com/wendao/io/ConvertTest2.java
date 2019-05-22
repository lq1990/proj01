package com.wendao.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 转换流 InputStreamReader OutputStreamWriter 1. 以字符流的形式 操作 字节流 （纯文本而言）
 * 
 * 2. 指定字符集
 * 
 * @author china
 *
 */
public class ConvertTest2 {
	public static void main(String[] args) {
		test2();
	}
	
	public static void test() {
		System.out.println("begin...");
		// System.in, .out
		// 操作网络流, 下载百度的源代码
		// 使用 转换流，将字节流转为字符流，并设置charset
		try (InputStreamReader is 
				= new InputStreamReader(new URL("https://www.baidu.com/").openStream(),
						"utf8");) {
			// 设置编码格式，才不会乱码
			int tmp;
			while((tmp = is.read())!=-1) {
				System.out.print((char)tmp);
			}
		} catch (IOException e) {
			System.out.println("异常");
			e.printStackTrace();
		}
	}
	
	public static void test2() {
		System.out.println("begin2...");
		// System.in, .out
		// 操作网络流, 下载百度的源代码
		// 使用 转换流，将字节流转为字符流，并设置charset
		try (BufferedReader reader =
				 new BufferedReader/*缓冲流，可提速*/(
						new InputStreamReader/*转换流，转成字符方便处理，且可以设置charset*/(
								new URL("https://www.baidu.com/")/*网络流*/.openStream(),
								"utf-8"));
			BufferedWriter writer =
					new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream("bd.html"), "utf8"));) {
			// 设置编码格式，才不会乱码
			String line = null;
			while((line = reader.readLine())!=null) {
//				System.out.println(line);
				writer.write(line);
				writer.newLine();
			}
			writer.flush();
			
		} catch (IOException e) {
			System.out.println("异常");
			e.printStackTrace();
		}
	}

}


