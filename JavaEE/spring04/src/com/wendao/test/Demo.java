package com.wendao.test;

public class Demo {
	public void demo01() throws Exception {
		int i=5/0;
		
		System.out.println("Demo.demo01()");
	}
	
	public void demo02() {
		System.out.println("Demo.demo02()");
	}
	
	public void demo03() {
		System.out.println("Demo.demo03()");
	}
	
	public void demo04(String name) {
		System.out.println("Demo.demmo04()");
	}
	
	public String demo05(String name) {
		
		return "这是Demo.demo05()的返回值";
	}
	
}
