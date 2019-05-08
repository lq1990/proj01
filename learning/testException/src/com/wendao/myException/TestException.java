package com.wendao.myException;

import java.lang.ArithmeticException;
import java.util.Scanner;


public class TestException {
	public static void main(String[] args) {
//		int i=1/0;
//		
		try {
			Thread.sleep(1000);
			System.out.println("try...");
		} catch (InterruptedException e) {
			System.out.println("catch...");
			e.printStackTrace();
		} finally {
			System.out.println("finally...");
		}
//		
//		Computer c = null;
//		if (c != null) {
//			c.start();
//		}
		
//		Scanner s = new Scanner(System.in);
//		System.out.println("pls input a int: ");
//		int a = s.nextInt();
//		System.out.println(a);
		
//		String s = "123abc";
//		Integer i = new Integer(s);
//		System.out.println(i);
		
	}
}


class Computer {
	void start() {
		System.out.println("start...");
	}
}