package com.wendao.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author china
 *
 */
public class Regexp03 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher("acdfaj1213 &* jk sjfk567897");
		
		
		// replace
		String newStr = m.replaceAll("#"); // 将 [0-9]匹配的字符，换成#
		System.out.println(newStr);
		
		
		
	}
}
