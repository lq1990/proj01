package com.wendao.test;

import com.wendao.Singleton;

public class Test {
	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s);
		System.out.println(s2);
		
		
		
	}
}
