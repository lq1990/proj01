package com.wendao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wendao.service.TestService;

public class TestAOP {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		TestService service = context.getBean("service", TestService.class);
		System.out.println(service.getClass().getName());
		service.test("测试执行");
		
	}
	
	public void test() {
		
	}
}
