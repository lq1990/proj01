package com.wendao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * JDK10 新特性
 * 
 * @author china
 *
 */
public class Demo1var {
	
	/**
	 * 	jdk10
	 * 		1. var只针对局部变量。
	 * 		2. var是保留类型，不是关键字。故var仍可用与定义变量名和方法名。
	 * 		3. var不允许赋值为null。无意义。
	 * @param args
	 */
	public static void main(String[] args) {
//		var aaa = null; 
		
		var i = 10;
		var str = "abc";
		var list = new ArrayList<Integer>();
		list.add(11);
		var set = new HashSet();
		set.add("set1");
		set.add("set2");
		var map = new HashMap();
		map.put("k","v");
		var user = new User();
		user.setUsername("anna");
		user.setUserage(60);
		
		for(var i1 = 0; i1<list.size(); i1++) {
			System.out.println(list.get(i1));
		}
		
		System.out.println();
		for(var s : set) {
			System.out.println(s);
		}
		
		System.out.println();
		System.out.println(user);
		
	}
}

class User {
	private String username;
	private Integer userage;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getUserage() {
		return userage;
	}
	public void setUserage(Integer userage) {
		this.userage = userage;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", userage=" + userage + "]";
	}
	
	
	
}









