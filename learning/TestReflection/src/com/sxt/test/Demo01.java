package com.sxt.test;

/**
 *	test
 *	java.lang.Class 对象的获取方式
 *	各种类型(class, interface, enum, annotation, primitive type, void)对应的java.lang.Class对象的获取方式
 *
 * @author china
 *
 */
public class Demo01 {
	
	public static void main(String[] args) throws ClassNotFoundException {
		String path = "com.sxt.test.bean.User";
		
		Class<?> clz = Class.forName(path); // 1. 
		System.out.println(clz.hashCode());

		Class clz2 = Class.forName(path);
		System.out.println(clz2.hashCode());
		
		Class strClz = String.class; // 2.
		System.out.println(strClz);
		
		Class strClz2 = path.getClass(); // 3.
		System.out.println(strClz2);
		System.out.println(strClz==strClz2);
	
		Class intClz = int.class;
		System.out.println(intClz);
		
		int[] a1 = new int[10];
		int[] a2 = new int[30];
		int[][] a3 = new int[10][5];
		System.out.println(a1.getClass().hashCode());
		System.out.println(a2.getClass().hashCode());
		System.out.println(a3.getClass().hashCode());
		
		
	}
	
}
