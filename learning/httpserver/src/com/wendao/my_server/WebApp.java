package com.wendao.my_server;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.wendao.my_server.*;

/**
 * 	当前问题：static{}中内容随着扩展代码而修改，应改进
 * @author china
 *
 */
public class WebApp {
	private static ServletContext context;
	
	// 静态初始化
	static {
		SAXParserFactory fac = SAXParserFactory.newInstance();
		// 2.
		try {
			SAXParser parser = null;
			WebHandler dh = new WebHandler();
			parser = fac.newSAXParser();
			parser.parse(Thread.currentThread().getContextClassLoader().
					getResourceAsStream("com\\wendao\\server\\demo04\\web.xml"), dh);
			
			List<Entity> entityList = dh.getEntityList();
			List<Mapping> mappingList = dh.getMappingList();
			
			context = new ServletContext();
			
			for(Mapping m : mappingList) {
				for (int i = 0; i < m.getUrlPattern().size(); i++) {
					context.getMapping().put(m.getUrlPattern().get(i) ,m.getName());
				}
			}
			
			for(Entity e : entityList) {
				context.getServlet().put(e.getName(), e.getClz());
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	
	}
	
	/** 
	 * 	由url 找到对应的Servlet
	 * @param url
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static Servlet getServlet(String url) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (null == url || ((url = url.trim()).equals(""))) {
			return null;
		}
		// 根据字符串（完整路径）创建对象
		String mapping = context.getMapping().get(url);
		String pkg = context.getServlet().get(mapping);
		Class<?> clz = Class.forName(pkg); // 获取Class对象
		Servlet serv = (Servlet)clz.newInstance(); // 实例。确保空构造存在
		return serv;
		
//		return context.getServlet().get(context.getMapping().get(url));
	}
}
