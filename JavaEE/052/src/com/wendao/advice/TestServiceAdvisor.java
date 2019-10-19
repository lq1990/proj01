package com.wendao.advice;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;

public class TestServiceAdvisor implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("前置通知, 方法名："+method.getName()+
				", 参数："+ Arrays.toString(args)+
				", 目标方法: "+target.getClass().getName());
		
	}

}
