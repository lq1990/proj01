package com.wendao.advice;

import java.lang.reflect.Method;
import java.rmi.RemoteException;

import javax.servlet.ServletException;

import org.springframework.aop.ThrowsAdvice;

/**
 * 实现接口 ThrowsAdvice 写afterThrowing方法， 抛Exception
 * 
 * @author china
 *
 */
public class MyThrow implements ThrowsAdvice {

//	public void afterThrowing(Exception ex) throws Throwable {
//		System.out.println("MyThrow.afterThrowing(), "
//				+ "执行异常通知，Schema-based方式 " 
//				+ ex.getMessage());
//	}

	/**
	 * 	至少传最后一个参
	 * @param m
	 * @param args
	 * @param target
	 * @param ex
	 */
	public void afterThrowing(Method m, 
			Object[] args, Object target, Exception ex) {

		System.out.println(
				"MyThrow.afterThrowing(), " + 
		"执行异常通知，Schema-based方式 " + ex.getMessage());
	}

}












