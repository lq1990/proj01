package com.wendao.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac 
			= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		People p = ac.getBean("people", People.class);
		System.out.println(p);

		People p1 = ac.getBean("people1", People.class);
		System.out.println(p1);
		
	}
}
