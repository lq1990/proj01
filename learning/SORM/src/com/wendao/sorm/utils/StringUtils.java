package com.wendao.sorm.utils;

/**
 * 	字符串常用的操作
 * @author china
 *
 */
public class StringUtils {
	
	/**
	 * 将目标字符串首字母变大写
	 * @param str 目标字符串
	 * @return
	 */
	public static String firstChar2UpperCase(String str) {
		// abcd --> Abcd
		// abcd --> ABCD --> Abcd
		return str.toUpperCase().substring(0,1)+str.substring(1);
	}
	
	
	
}
