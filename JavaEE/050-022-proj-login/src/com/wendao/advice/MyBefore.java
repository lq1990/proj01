package com.wendao.advice;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import com.wendao.pojo.Users;


/**	
 * 	给配置的 com.wendao.service.impl.UsersServiceImpl.login(..)) 切点，配置前置通知
 * 
 * @author china
 *
 */
public class MyBefore implements MethodBeforeAdvice {
	Logger logger = Logger.getLogger(MyBefore.class);

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		Users users = (Users) arg1[0];
		
		logger.info(users.getUsername()
				+"在"+new Date().toLocaleString()+"进行登录");
		
	}

	
}
