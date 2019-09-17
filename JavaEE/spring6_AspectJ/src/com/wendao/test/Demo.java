package com.wendao.test;

/**
 * 	AOP,
 * 	切点方法
 * @author china
 *
 */
public class Demo {
	public void demo1(String name, int age) throws Exception {
//		int i = 5 / 0;

		System.out.println("Demo.demo1(两个参), "+name+", "+age);
	}
	
	public void demo1(String name) {
		System.out.println("Demo.demo1(一个惨), "+name);
	}

}
