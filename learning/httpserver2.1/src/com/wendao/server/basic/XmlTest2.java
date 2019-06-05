package com.wendao.server.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 熟悉SAX解析流程
 * 
 * @author china
 *
 */
public class XmlTest2 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// 1.
		SAXParserFactory fac = SAXParserFactory.newInstance();
		// 2.
		SAXParser parser = fac.newSAXParser();
		// 3.
		PersonHandler handler = new PersonHandler();
		parser.parse(
				Thread.currentThread().getContextClassLoader().getResourceAsStream("com/wendao/server/basic/p.xml"),
				handler);

		List<Person> persons = handler.getPersons();
		for (Person person : persons) {
			System.out.println(person.getName() + ": " + person.getAge());
		}

	}
}

class PersonHandler extends DefaultHandler {
	private List<Person> persons;
	private Person person;
	private String buf;

	public PersonHandler() {
	}

	public List<Person> getPersons() {
		return persons;
	}

	@Override
	public void startDocument() throws SAXException {
		persons = new ArrayList<Person>();

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName + "元素解析 开始 -->");
		this.buf = qName;
		if (null != qName && qName.equals("person")) {
			this.person = new Person();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch, start, length).trim();
		// 内容有可能为空，所以要考虑
		if (null != contents && contents.length() > 0) {
			if (null != this.buf && this.buf.equals("name")) {
				this.person.setName(contents);
			} else if (null != this.buf && this.buf.equals("age")) {
				int age = Integer.parseInt(contents);
				this.person.setAge(age);
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName + "元素解析 结束 <--");
		this.buf = null;
		if (null != qName && qName.equals("person")) {
			this.persons.add(person);
		}
	}

	@Override
	public void endDocument() throws SAXException {
	}
}
