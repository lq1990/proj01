package com.wendao.pojo;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		
		Mishu mishu = new Mishu();
		
		/**
		 * 	第一个参：反射时使用的 类加载器
		 * 	第二个参：Proxy需要实现什么接口
		 * 	第三个参：通过接口对象调用方法时，需要调用哪个类的invoke方法
		 */
		Gongneng gn = 
				(Gongneng) Proxy.newProxyInstance(
						Client.class.getClassLoader(),
						new Class[] {Gongneng.class}, 
						mishu);
		
		gn.chifan();
		gn.zhidingxiaomubiao();
	}
}
