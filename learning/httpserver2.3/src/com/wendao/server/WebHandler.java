package com.wendao.server;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * 
 * Handler for SAXParser
 * 
 * @author china
 *
 */
public class WebHandler extends DefaultHandler {
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
