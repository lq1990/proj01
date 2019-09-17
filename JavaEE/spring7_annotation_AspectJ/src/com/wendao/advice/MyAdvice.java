package com.wendao.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 	注解
 * 	Component： IoC，使得spring管理此类, <bean>
 * 	Aspect: 设置此类为 通知切面类，此类的方法是 通知方法, <aop:aspect>
 * 
 * @author china
 *
 */
@Component
@Aspect
public class MyAdvice {
	
	/**
	 * 	注解
	 * 	Before() 括号内是切点
	 */
	@Before("com.wendao.test.Demo.demo1()")
	public void mybefore() {
		System.out.println("MyAdvice.mybefore()");
	}
	
	
	@After("com.wendao.test.Demo.demo1()")
	public void myafter() {
		System.out.println("MyAdvice.myafter() "+"后置通知");
	}
	
	@AfterThrowing("com.wendao.test.Demo.demo1()")
	public void mythrow() {
		System.out.println("MyAdvice.mythrow()");
	}
	
	@Around("com.wendao.test.Demo.demo1()")
	public Object myarround(ProceedingJoinPoint p) throws Throwable {
		System.out.println("MyAdvice.myarround()"+"前");
		Object res = p.proceed();
		System.out.println("MyAdvice.myarround()"+"后");
		
		return res;
	}
	
}










