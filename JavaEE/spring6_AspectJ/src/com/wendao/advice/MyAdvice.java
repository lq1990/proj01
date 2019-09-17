package com.wendao.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	public void mybefore(String name, int age) {
		System.out.println("MyAdvice.mybefore(两个参)"+"前置通知, "+name+", "+age);
		
	}
	
	public void mybefore1(String name) {
		System.out.println("MyAdvice.mybefore(一个参)"+"前置通知, "+name);
	}
	
	public void myafter() {
		System.out.println("MyAdvice.myafter()"+"后置通知");
	}
	
	public void myafterreturing() {
		System.out.println("MyAdvice.myafterreturing()"+"后置通知");
	}
	
	public void mythrow() {
		System.out.println("MyAdvice.mythrow()"+"异常通知");
	}
	
	public Object myarround(ProceedingJoinPoint p) throws Throwable {
		System.out.println("MyAdvice.myarround()"+"环绕通知 前");
		Object res = p.proceed();
		System.out.println("MyAdvice.myarround()"+"环绕通知 后");
		
		return res;
	}
	
}
