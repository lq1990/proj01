package com.wendao.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * test regexp in java
 * 
 * @author china
 *
 */
public class Regexp01 {
	public static void main(String[] args) {
		// afdafds4314jk32j1kjk2345, if match \w+
		
		// regexp
		Pattern p = Pattern.compile("\\w+"); // in java \\ means \
		
		// Matcher
		Matcher m = p.matcher("abc123^&j1kjk2345");
//		boolean is = m.matches();
		
//		boolean is2 = m.find(); // 扫描输入的序列，查找匹配的下一个序列
		while(m.find()) {
			System.out.println(m.group()); // print the content that's found
			// m.group(0) => m.group() 匹配整个表达式的子字符串
			
		}
		
		
		
	}
}
