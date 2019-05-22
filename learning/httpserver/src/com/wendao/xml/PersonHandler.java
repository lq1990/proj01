package com.wendao.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 存储对象
 * @author china
 *
 */
public class PersonHandler extends DefaultHandler {
	private List<Person> persons;
	private Person person;
	private String tag; // 记录标签名
	
	

	public List<Person> getPersons() {
		return persons;
	}


	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		
		System.out.println("处理文档开始");
		// 开始文档时，初始化list
		persons = new ArrayList<Person>();
	}


	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		System.out.println("开始一个元素"+qName);
		if (null != qName) {
			tag = qName;
		}
		if (null != qName && qName.equals("person")) {
			this.person = new Person();
		}
	}
	
	@Override
	/**
	 * characters是具体的内容  <>content</>
	 */
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String str = new String(ch, start, length);
		if (null != tag && tag.equals("name")) {
			person.setName(str);
		} else if (null != tag && tag.equals("age")) {
			Integer age = Integer.valueOf(str);
			person.setAge(age);
		}
		System.out.println(str);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		System.out.println("结束一个元素");
		// 把person加到 persons list中
		if (qName.equals("person")) {
			this.persons.add(person);
		}
		
		tag = null;
	}
	
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("处理文档结束");
	}

	
}
 