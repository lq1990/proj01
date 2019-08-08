package com.wendao.junit4;

/**
 * 
 * @author china
 *
 */
public class T {
	public static void main(String[] args) {
		int res = new T().add(11, 22);
		System.out.println(res);
	}
	
	public int add(int x, int y) {
		return x + y;
	}
}
