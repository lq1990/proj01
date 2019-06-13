package com.wendao.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author china
 *
 */
public class Regexp02 {
	
	static {
		System.out.println("static Regexp02");
		System.out.println("-----------------");
	}
	
	public static void main(String[] args) {
		Pattern p = Pattern.compile("([a-z]+)([0-9]+)");
		Matcher m = p.matcher("abcdefg12345^&7878dsaf4314");
		
		while(m.find()) {
			System.out.println(m.group());  // 所有组一起
			System.out.println(m.group(1)); // 第一组
			System.out.println(m.group(2)); // 第二组
			System.out.println();
		}
		
	}
}
