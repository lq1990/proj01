package com.wendao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * 
 * @author china
 *
 */
public class Demo05Reader_transferTo {
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("d:/myGithub/p.txt"),"gbk"));
//		var p = new PrintWriter("d:/myGithub/pp.txt", "gbk");
		var f = new FileWriter("d:/myGithub/ppp.txt",Charset.forName("gbk"));
		
		reader.transferTo(f);
		f.flush();
		f.close();
		reader.close();
		
		System.out.println("main 5");
	}
}






































