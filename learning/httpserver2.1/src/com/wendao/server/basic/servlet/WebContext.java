package com.wendao.server.basic.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 上下文：承接 xml 和 server
 * @author china
 *
 */
public class WebContext {
	private List<Entity> entities = null;
	private List<Mapping> mappings = null;
	private Map<String, String> entityMap; // key: name, value: class
	private Map<String, String> mappingMap; // key: url, value: name
	// 借助Map的好处，此类new一次后，虽然创建map 要遍历耗时，但只耗时一次。
	// 在多次使用时，快。
	
	/**
	 * @param entities 解析xml后得到的, name -> clz
	 * @param mappings name -> url
	 */
	public WebContext(List<Entity> entities, List<Mapping> mappings) {
		this.entities = entities;
		this.mappings = mappings;
		this.entityMap = new HashMap<String, String>();
		this.mappingMap = new HashMap<String, String>();
		
		for(Entity e : entities) {
			this.entityMap.put(e.getName(), e.getClz());
		}
		for(Mapping m : mappings) {
			String name = m.getName();
			for(String aUrl : m.getPatterns()) {
				this.mappingMap.put(aUrl, name);
			}
		}
	}
	
	public String getClz(String url) {
		String name = this.mappingMap.get(url);
		if (null == name || name.equals("")) {
			return null;
		}
		return this.entityMap.get(name);
	}
	
	/*// 这种方法虽简单，但若多次getClz，每次都要遍历所有就慢了。不如在构造obj时，创建map
	public String getClz(String url) {
		String name = this.getName(url);
		if (null == name || name.equals("")) {
			return null;
		}
		
		for(Entity e : this.entities) {
			if (e.getName().equals(name)) {
				return e.getClz();
			}
		}
		return null;
	}
	
	private String getName(String url) {
		for(Mapping m : this.mappings) {
			if(m.getPatterns().contains(url)) {
				return m.getName();
			}
		}
		return null;
	}
	*/
}
