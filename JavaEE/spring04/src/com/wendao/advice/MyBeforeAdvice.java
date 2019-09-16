package com.wendao.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice {

	/**
	 *  Method: 反射中，方法
	 *  Object[]: 传参
	 *  Object: 切点在哪个对象中, pkg.Class对象
	 *  
	 *  	前置通知不能获取pointcut执行返回值
	 */
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
//		System.out.println("Method arg0, 切点方法对象："+arg0+", 方法名: "+arg0.getName());
//		
//		
//		if(arg1 != null && arg1.length > 0) {
//			System.out.println("Object[] arg1, 切点方法参数："+arg1[0]);
//		} else {
//			System.out.println("Object[] arg1, 切点没参数");
//		}
//			
//		
//		System.out.println("Object arg2, 对象："+arg2);
		
		System.out.println("执行前置通知");
		
	}
	
}
