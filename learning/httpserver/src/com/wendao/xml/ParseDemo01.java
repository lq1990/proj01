package com.wendao.xml;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParseDemo01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// 1. 获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2. 从解析工厂获得解析器
		SAXParser parser = factory.newSAXParser();
		// 3. 加载文档Document，指定处理器
		PersonHandler handler = new PersonHandler();
		parser.parse(Thread.currentThread().
				getContextClassLoader().
				getResourceAsStream("com/wendao/xml/person.xml"), 
					handler);
		
		List<Person> persons = handler.getPersons();
		for(Person p : persons) {
			System.out.println(p.getName()+": "+p.getAge());
		}
		
	}
}
