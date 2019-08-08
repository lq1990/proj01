package com.wendao;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 
 * @author china
 *
 */
public class Demo04PrintStreamPrintWriterWithCharset {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		String str = "我喜欢学习喜欢我吗";
		var p = new PrintWriter("d:/myGithub/p.txt", "gbk");
		// 把str内容print到文件中
		
		p.println(str);
		p.flush();
		p.close();
		
	}
}
