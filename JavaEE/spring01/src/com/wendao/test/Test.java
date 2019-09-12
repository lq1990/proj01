package com.wendao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wendao.pojo.People;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		People p = ac.getBean("peo", People.class);
		System.out.println(p);
		
		
		
	}
}
