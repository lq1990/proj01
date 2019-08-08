package com.wendao.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * dom4j 生成xml文件
 * 
 * @author china
 *
 */
public class TestXML02 {
	public static void main(String[] args) throws IOException {
		// create
		Document doc = DocumentHelper.createDocument();
		
		// add root
		Element root = doc.addElement("books"); // return this root
		
		// add elem for root
		Element book = root.addElement("book");
		
		// for book, add attr
		book.addAttribute("id", "b01");
		
		// for book, add elem
		Element name = book.addElement("name");
		Element author = book.addElement("author");
		Element price = book.addElement("price");
		
		// for each elem, add text
		name.addText("Thinking in Java");
		author.addText("xiao xiao");
		price.addText("88");
		
		// book2
		book = root.addElement("book").addAttribute("id", "b02");
		book.addElement("name").addText("java2");
		book.addElement("author").addText("anna");
		book.addElement("price").addText("67");
		
		// =================================================
		// export doc to xml file。会是一行。
		/*
		Writer w = new FileWriter("src/books2.xml");
		doc.write(w);
		
		// free resource
		w.close();
		*/
		
		// =================================================
		OutputFormat format = OutputFormat.createPrettyPrint();
		Writer w = new FileWriter("src/books2.xml");
		XMLWriter writer = new XMLWriter(w, format);
		writer.write(doc);
		
		writer.close();
		w.close();
	}
}












