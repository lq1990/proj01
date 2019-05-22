package com.sxt.io;

/**
 * recursive
 * 
 * @author china
 *
 */
public class DirDemo03 {
	public static void main(String[] args) {
		printTen(1);
	}
	
	
	public static void printTen(int n) {
		if (n>10) {
			return;
		}
		System.out.println(n);
		printTen(n+1);
	}
}
