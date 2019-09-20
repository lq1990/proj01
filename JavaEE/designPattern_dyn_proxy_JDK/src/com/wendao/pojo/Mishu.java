package com.wendao.pojo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 	JDK提供的动态代理
 * 	需要实现 InvocationHandler
 * 
 * @author china
 *
 */
public class Mishu implements InvocationHandler {
	private Laozong lz = new Laozong("anna");

	/**
	 * 	在调动任意功能时，都要走这个
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("预约时间");
		
		Object res = method.invoke(lz, args); // 第一个参：真实对象
		
		System.out.println("记录");
		
		return res;
	}

}
