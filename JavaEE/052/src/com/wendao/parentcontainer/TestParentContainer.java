package com.wendao.parentcontainer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestParentContainer {
	public static void main(String[] args) {
		ApplicationContext parent = 
				new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		ApplicationContext child = 
				new ClassPathXmlApplicationContext(new String[] { "classpath:applicationContext2.xml"}, parent);
		
		
		
		System.out.println("context1, a: "+parent.getBean("a"));
//		System.out.println("context1, b: "+parent.getBean("b"));
		
		System.out.println("context2, a: "+child.getBean("a"));
		System.out.println("context2, b: "+child.getBean("b"));
		
		
		System.out.println(parent.getBean("oneBean"));
		
	}
}
