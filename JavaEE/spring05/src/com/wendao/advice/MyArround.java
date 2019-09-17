package com.wendao.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class MyArround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("环绕-前置");
		
		Object result = arg0.proceed(); // 放行，调用切点方法，有方法的返回值
		
		System.out.println("环绕-后置");
		return result;
	}

	

}
