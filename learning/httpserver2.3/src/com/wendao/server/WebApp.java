package com.wendao.server;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


/**
 * parse xml
 * Tips: file location is in src/
 * 
 * get Servlet from given url
 * 
 * @author china
 *
 */
public class WebApp {
	private static WebContext context;
	
	// init. static
	static {
		try {
			// 1.
			SAXParserFactory fac = SAXParserFactory.newInstance();
			// 2.
			SAXParser parser = fac.newSAXParser();
			// 3.
			WebHandler handler = new WebHandler();
			// 4. 5.
			parser.parse(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("web.xml"), 
					handler);
			
			List<Entity> entities = handler.getEntities();
			List<Mapping> mappings = handler.getMappings();
			context = new WebContext(entities, mappings);
		} catch(Exception e) {
			System.out.println("解析配置文件错误");
		}
	}
	
	/**
	 * get Servlet form url
	 * 
	 * @param url
	 * @return
	 */
	public static Servlet getServletFromURL(String url) {
		String clzName = context.getClz(url);
		Class<?> clz;
		try {
			clz = Class.forName(clzName);
			Servlet serv = (Servlet) clz.getConstructor().newInstance(); 
			return serv;
		} catch (Exception e) {
//			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
