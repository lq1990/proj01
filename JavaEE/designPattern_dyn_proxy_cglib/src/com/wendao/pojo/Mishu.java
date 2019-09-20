package com.wendao.pojo;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Mishu implements MethodInterceptor {

	/**
	 * 	arg0: 子类对象
	 * 	arg1: 代理的方法。此处看起来时反射，其实生成字节码了，效率高
	 * 	arg2：参数
	 * 	arg3：子类重写的方法
	 */
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("预约时间");
//		arg1.invoke(arg0, arg2);
		Object res = arg3.invokeSuper(arg0, arg2);
		
//		Object res = arg3.invoke(arg0, arg2); // 这个会不断递归
		
		System.out.println("备注");
		return res;
		
	}

}
