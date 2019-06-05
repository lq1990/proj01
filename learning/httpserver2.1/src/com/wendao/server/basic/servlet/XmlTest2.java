package com.wendao.server.basic.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * ��ϤSAX��������
 * 
 * @author china
 *
 */
public class XmlTest2 {
	public static void main(String[] args) throws Exception {
		// 1.
		SAXParserFactory fac = SAXParserFactory.newInstance();
		// 2.
		SAXParser parser = fac.newSAXParser();
		// 3.
		WebHandler handler = new WebHandler();
		// 4. 5.
		parser.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("com/wendao/server/basic/servlet/web.xml"), 
				handler);

		
		List<Entity> entities = handler.getEntities();
		List<Mapping> mappings = handler.getMappings();
		WebContext context = new WebContext(entities, mappings);
		String clzName = context.getClz("/login");
		Class<?> clz = Class.forName(clzName);
		
		Servlet serv = (Servlet) clz.getConstructor().newInstance(); 
		serv.service();
		
	}
}

class WebHandler extends DefaultHandler {
	private List<Entity> entities;
	private List<Mapping> mappings;
	private Entity entity;
	private Mapping mapping;
	private String buf;
	private boolean isEntity = false;

	public WebHandler() {
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

	@Override
	public void startDocument() throws SAXException {
		entities = new ArrayList<Entity>();
		mappings = new ArrayList<Mapping>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//		System.out.println(qName + "Ԫ�ؽ��� ��ʼ -->");
		this.buf = qName;
		if (null != qName && qName.equals("servlet")) {
			// entity
			this.entity = new Entity();
			this.isEntity = true;
		} else if (null != qName && qName.equals("servlet-mapping")) {
			// mapping
			this.mapping = new Mapping();
			this.isEntity = false;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch, start, length).trim();
		// �����п���Ϊ�գ�����Ҫ����
		if (null != contents && contents.length() > 0) {
			if (null != this.buf && this.buf.equals("servlet-name")) {
				if (isEntity) {
					this.entity.setName(contents);
				} else {
					this.mapping.setName(contents);
				}
			} else if (null != this.buf && this.buf.equals("servlet-class")) {
				this.entity.setClz(contents);
			} else if (null != this.buf && this.buf.equals("url-pattern")) {
				this.mapping.addPattern(contents);
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
//		System.out.println(qName + "Ԫ�ؽ��� ���� <--");
		this.buf = null;
		if (null != qName && qName.equals("servlet")) {
			this.entities.add(entity);
		} else if (null != qName && qName.equals("servlet-mapping")) {
			this.mappings.add(mapping);
		}
	}

	@Override
	public void endDocument() throws SAXException {
	}
}
