package com.wendao.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wendao.pojo.Airport;
import com.wendao.pojo.People;
import com.wendao.service.impl.AirportServiceImpl;

public class Test {
	public static void main(String[] args) {

		ApplicationContext ac 
			= new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		String[] names = ac.getBeanDefinitionNames();
//		for (String s : names) {
//			System.out.println(s);
//		}
		
		
		AirportServiceImpl bean 
			= ac.getBean("airportService", AirportServiceImpl.class);
		List<Airport> list = bean.show();
		System.out.println(list);
		
		
		
	}
}
