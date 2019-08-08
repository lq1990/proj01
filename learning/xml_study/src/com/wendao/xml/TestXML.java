package com.wendao.xml;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestXML {
	public static void main(String[] args) throws Exception {
		// create SAXReader
		SAXReader reader = new SAXReader();
		
		// read xml file
		Document doc = reader.read(new File("src/scores2.xml"));
		
		// get root
		Element root = doc.getRootElement();
		System.out.println(root.getName());

		// get all elem of root
		Iterator<?> it = root.elementIterator();
		while(it.hasNext()) {
			// get elem
			Element e = (Element) it.next();
			System.out.println(e.getName());
			
			// get id
			Attribute id = e.attribute("id");
			System.out.println("  "+id.getName()+" = "+id.getValue());
			
			// get elem of student
			Element name = e.element("name");
			Element course = e.element("course");
			Element score = e.element("score");
			
			// print
			System.out.println("\t"+name.getName()+" = "+name.getStringValue());
			System.out.println("\t"+course.getName()+" = "+course.getText());
			System.out.println("\t"+score.getName()+" = "+score.getStringValue());
			System.out.println("-----------------");
			
		}
		
		
	}
}















