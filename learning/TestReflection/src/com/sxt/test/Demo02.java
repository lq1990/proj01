package com.sxt.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * 	应用反射的API，获取类的信息(类的名字，属性，方法，构造器)
 * 
 * @author china
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String path = "com.sxt.test.bean.User";
		try {
			Class clz = Class.forName(path);
			
			// 获取类的名字
			System.out.println(clz.getName()); // 包括 包名+类名
			System.out.println(clz.getSimpleName()); // 获得类名 User
			
			// 获得属性信息
			Field[] fs = clz.getFields(); // 只能获得public的属性
			Field[] fs2 = clz.getDeclaredFields(); // 获得所有属性
			System.out.println(fs.length);
			System.out.println(fs2.length);
			
			for (Field field : fs2) {
				System.out.println(field);
			}
			
			System.out.println();
			// 获得方法信息
			Method[] methods = clz.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(method);
			}
			
			System.out.println();
			
			// 获得构造器信息
			Constructor[] cts = clz.getDeclaredConstructors();
			for (Constructor constructor : cts) {
				System.out.println("构造器："+constructor);
			}
			// 获得指定的构造器 
			Constructor ct1 = clz.getDeclaredConstructor(int.class, int.class, String.class);
			System.out.println(ct1);
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}














