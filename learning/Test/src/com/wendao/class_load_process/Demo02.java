package com.wendao.class_load_process;

/**
 * 
 * ClassLoader
 * 
 * @author china
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		
		System.out.println();
		System.out.println("当前类加载器位置：\r\n"+System.getProperty("java.class.path"));
		
		System.out.println();
		String a = "gaogao";
		System.out.println(a.getClass().getClassLoader()); // null
		System.out.println(a);
		
	}
}
