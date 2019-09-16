package com.wendao.advice;

import org.springframework.aop.ThrowsAdvice;

public class MyThrowAdvice {
	public void myexception(Exception e) {
		System.out.println("执行异常通知, 异常msg： "+e.getMessage());
	}
}
