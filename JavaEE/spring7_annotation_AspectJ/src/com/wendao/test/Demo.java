package com.wendao.test;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 	使用注解 替代xml配置。
 * 
 * 	Component注解，等价于xml配置中的 <bean>，即IoC
 * @author china
 *
 */
@Component
public class Demo {
	
	/**
	 * 	注解：Pointcut() ，括号内是切点的名，最好是包类方法名
	 * @throws Exception
	 */
	@Pointcut("execution(* com.wendao.test.Demo.demo1() )")
	public void demo1() throws Exception {
//		int i = 5 / 0;

		System.out.println("Demo.demo1()");
	}
	
}
