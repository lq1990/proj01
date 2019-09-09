package com.wendao.test;

public class Test {
	public static void main(String[] args) {
		// final修饰，不允许重新实例化了。或者把tl作为Test类的属性
		final ThreadLocal<String> tl = new ThreadLocal<String>();
		tl.set("测试");
		
		// 匿名内部类，再重写类方法
		new Thread() {
			public void run() {
				String val = tl.get();
				System.out.println("res: "+val);
				
				
			};
		}.start();
		
		
		
		
	}
}
