package com.wendao.ds.stackqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 	将10进制转为2进制
 * @author china
 *
 */
public class TestConvertUsingStack {
	
	private static void test01() {
		String str = "";
		// 给定一个十进制数
		int n = 11;
		
		// 转为二进制
		int devident = n; // 被除数
		
		do {
			// /2 求余数
			int mod = devident % 2;
			System.out.println("mod: "+mod);
			
			// 得到商，更新被除数
			devident = devident / 2;
			
			// save mod
			str = mod + str;
			
		} while (devident > 0);
		
		// output
		System.out.println(n+" --> " +str);
	}
	
	private static void test02() {
		Deque<Integer> stack = new LinkedList<Integer>();
		// 给定一个十进制数
		int n = 33;
		
		// 转为二进制
		int devident = n; // 被除数
		
		do {
			// /2 求余数
			int mod = devident % 2;
			System.out.println("mod: "+mod);
			
			// 得到商，更新被除数
			devident = devident / 2;
			
			// save mod
			stack.push(mod);
			
		} while (devident > 0);
		
		// output
		System.out.print(n+" --> ");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
	
	public static void main(String[] args) {
		test02();
		
		
	}
	
}





