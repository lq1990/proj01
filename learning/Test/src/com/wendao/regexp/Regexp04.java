package com.wendao.regexp;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * split
 * 
 * @author china
 *
 */
public class Regexp04 {
	public static void main(String[] args) {
		String str = "a123b231d213d321 ";
		String[] strArr = str.split("[0-9]+");
		System.out.println(Arrays.toString(strArr));
		

		
	}
}
