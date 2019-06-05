package com.wendao.test.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 注解 Annotation
 * 
 * @author china
 *
 */
@SuppressWarnings("all")
public class Demo01 extends Object {

	@Override
	public String toString() {
		return "";
	}
	// 有了注解，当所写fn并不是父类中的方法，则编译器报错
	
	@Deprecated
	public static void test01() {
		System.out.println("test01");
	}
	
	@SuppressWarnings("all")
	public static void test02() {
		List list = new ArrayList();
		
	}
	
	public static void main(String[] args) {
		Date d = new Date();
			
		test01();
		
		int[] i = {1, 2, 3};
		System.out.println(i);
	}
}
