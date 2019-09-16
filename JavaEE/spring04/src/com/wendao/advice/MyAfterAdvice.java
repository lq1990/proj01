package com.wendao.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("Object arg0: "+arg0);
		
		System.out.println("Method arg1, 切点方法对象："+arg1+", 方法名: "+arg1.getName());
		
		if(arg2 != null && arg2.length > 0) {
			System.out.println("Object[] arg2, 切点方法参数："+arg2[0]);
		} else {
			System.out.println("Object[] arg2, 切点没参数");
		}
			
		
		System.out.println("Object arg3, 对象："+arg3);
		
		System.out.println("执行后置通知");
		
		
	}
	
}
