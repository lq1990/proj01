package com.wendao;

/**
 * 	饿汉式，不需要锁
 * @author china
 *
 */
public class Singleton {
	
	// 在类加载时进行实例化
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
	}
	
	
	public static Singleton getInstance() {
		return singleton;
	}
	
}












