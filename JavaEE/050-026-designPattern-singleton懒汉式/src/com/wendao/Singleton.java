package com.wendao;

public class Singleton {
	
	private static Singleton singleton;
	
	/**
	 * 	构造方法：
	 * 		方法名和类名相同
	 * 		无返回值
	 * 
	 * 	private构造方法，使外部不能实例化
	 * 
	 * 	需要对外提供一个访问入口
	 * 
	 */
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 	实例方法的话，外部不能new实例之后通过实例 getInstance()
	 * 	所以需要static修饰
	 * 
	 * 	多线程访问下，
	 * @return
	 */
	public static Singleton getInstance() {
		// 逻辑判断，若实例化过 则直接返回
		if(singleton == null) {
			
			/**
			 * 多线程访问下，
			 */
			synchronized (Singleton.class) {
				// 双重验证
				if(singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		
		return singleton;
	}
	
}












