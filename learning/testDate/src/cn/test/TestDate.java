package cn.test;

import java.util.Date;

public class TestDate {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		
		Date d2 = new Date(1000);
		System.out.println(d2.toGMTString());
		System.out.println(d2.getTime()); // 1000
		System.out.println("########");
		System.out.println(d2.toString());
		
		int a = 0;
		System.out.println(false && a++==2); // ¶ÌÂ·ÔËËã·û
		System.out.println(a); // 0
	}	
}
