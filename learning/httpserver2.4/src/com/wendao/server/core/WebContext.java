package com.wendao.server.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * get Clz(String type) from a url,
 * i.e. Clz is to be transformed into Class Object with java.lang.reflect
 * 
 * WebContext is used in WebApp
 * to getServletFromUrl
 * 
 * 
 * @author china
 *
 */
public class WebContext {
	private List<Entity> entities = null;
	private List<Mapping> mappings = null;
	private Map<String, String> entityMap; // key: name, value: class
	private Map<String, String> mappingMap; // key: url, value: name
	// advantages of using Map: create once, multiple use
	
	/**
	 * @param entities name -> clz
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
			
			// traverse each url-pattern
			for(String aUrl : m.getPatterns()) {
				this.mappingMap.put(aUrl, name);
				// multiple urls maps a same name
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
	
}
