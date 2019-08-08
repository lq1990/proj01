package com.wendao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Scanner 新增了 带charset的构造器
 * @author china
 *
 */
public class Demo06Scanner {
	public static void main(String[] args) throws FileNotFoundException {
		var scan = new Scanner(new FileInputStream("d:/myGithub/p.txt"),"gbk");
		scan.useDelimiter(" |,");
		while(scan.hasNext()) {
			System.out.println(scan.next());
		}
		
		
	}
}








































