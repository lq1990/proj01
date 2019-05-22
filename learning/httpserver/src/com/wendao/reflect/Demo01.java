package com.wendao.reflect;

/**
 * 获取结构信息 class对象（源头）
 * 
 * @author china
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ClassNotFoundException {
		String str = "abc";
		
		// option 1: obj.getClass()
		Class<?> clz = str.getClass();
		
		// opt 2: AClass.class
		clz = String.class;
		
		// opt 3: 完整路径。常用
		clz = Class.forName("java.lang.String");
		
		
		
	}
}
