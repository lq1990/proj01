package com.wendao.class_load_process;

/**
 * 
 * @author china
 *
 */
public class Demo01 {
	
	static {
		System.out.println("静态初始化Demmo01");
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
//		String str = "abc";
//		int a = 12321;
		
//		System.out.println("Demo01.main()");
//		A a = new A();
//		System.out.println(A.width);
//		A a2 = new A();
		
		// 主动引用，一定会发生类的初始化
//		new A();
//		System.out.println(A.width);
//		Class.forName("com.wendao.class_load_process.A");
		
		// 被动引用
//		System.out.println(A.MAX);
//		A[] as = new A[10];
		System.out.println(B.width); // B不会初始化
		
		
	}
}

// 在常量池中：类名、方法名、参数、字符串常量、变量 等等变量常量


class B extends A {
	static {
		System.out.println("static init B");
	}
}

class A extends AFather {
	public static int width = 100;
	public static final int MAX = 999;
	
	static {
		System.out.println("静态初始化类A");
		width = 300;
	}
	
	public A() {
		System.out.println("创建A的对象");
		
	}
}

class AFather {
	static {
		System.out.println("静态初始化AFather");
	}
	
	
}



















