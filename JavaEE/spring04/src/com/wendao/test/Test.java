package com.wendao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	
	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo demo = ac.getBean("demo", Demo.class);
		try {
			demo.demo01();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		System.out.println();
		
//		demo.demo02(); System.out.println();
//		demo.demo03(); System.out.println();
//		demo.demo04("传给demo.demo04()的参数"); System.out.println();
//		demo.demo05(""); System.out.println();
//		
//		System.out.println("=========================");
//		Demo1 demo1 = ac.getBean("demo1", Demo1.class);
//		demo1.demo11();
		
		
	}

}
