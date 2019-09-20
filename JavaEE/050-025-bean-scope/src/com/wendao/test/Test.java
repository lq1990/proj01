package com.wendao.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac 
			= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Teacher t1 = ac.getBean("teacher1", Teacher.class);
		Teacher t2 = ac.getBean("teacher1", Teacher.class);
		
		System.out.println(t1==t2); // true
		
		
		
	}
}
