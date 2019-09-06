package com.wendao.test;

public class Test {
	public static void main(String[] args) {
		final ThreadLocal<String> tl = new ThreadLocal<String>();
		tl.set("abc"); // 一个 ThreadLocal只能设置一个值
		
		// new thread
		new Thread() {

			@Override
			public void run() {
				
				String str = tl.get();
				System.out.println(str); // null，main线程定义的值，其它线程拿不到

				
			}
			
		}.start();
		
		
	}
}
