package com.wendao.my_server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WebHandler extends DefaultHandler {
	private List<Entity> entityList;
	private List<Mapping> mappingList;
	private Entity entity;
	private Mapping mapping;
	private String beginTag;
	private boolean isMap;
	
	public List<Entity> getEntityList() {
		return entityList;
	}

	public List<Mapping> getMappingList() {
		return mappingList;
	}

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		// 文档解析开始
		this.entityList = new ArrayList<Entity>();
		this.mappingList = new ArrayList<Mapping>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		// 开始元素
		if (null != qName) {
			this.beginTag = qName; // 将qName存起来，备用

			if (qName.equals("servlet")) {
				isMap = false;
				this.entity = new Entity();
			} else if (qName.equals("servlet-mapping")) {
				isMap = true;
				this.mapping = new Mapping();
			}
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		// 内容
		if (null != this.beginTag) {
			String str = new String(ch, start, length);
			
			if (isMap) {
				if (beginTag.equals("servlet-name")) {
					this.mapping.setName(str);
				} else if (beginTag.equals("url-pattern")) {
					this.mapping.getUrlPattern().add(str);
				}
			} else {
				if (beginTag.equals("servlet-name")) {
					this.entity.setName(str);
				} else if (beginTag.equals("servlet-class")) {
					this.entity.setClz(str);
				}
			}
			
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		// 结束元素
		if (null != qName) {
			if (qName.equals("servlet")) {
				this.entityList.add(this.entity);
			} else if (qName.equals("servlet-mapping")) {
				this.mappingList.add(this.mapping);
			}
		}
		
		beginTag = null;
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		// 解析文档结束
	}
	
	/*
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// 1. 获取解析工厂
		SAXParserFactory fac = SAXParserFactory.newInstance();
		// 2.
		SAXParser parser = fac.newSAXParser();
		// 3.
		WebHandler dh = new WebHandler();
		parser.parse(Thread.currentThread().getContextClassLoader().
				getResourceAsStream("com\\wendao\\server\\demo04\\web.xml"), dh);
		
		List<Entity> entityList = dh.getEntityList();
		List<Mapping> mappingList = dh.getMappingList();
		for(Entity e : entityList) {
			System.out.println(e.getName()+" -> "+e.getClz());
		}
		for(Mapping m : mappingList) {
			System.out.println(m.getName()+" -> "+m.getUrlPattern());
		}
		
	}
	*/
}








