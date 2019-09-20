package com.wendao.service.impl;

import org.springframework.beans.factory.annotation.Value;

import com.wendao.mapper.UsersMapper;
import com.wendao.pojo.Users;
import com.wendao.service.UsersService;

public class UsersServiceImpl implements UsersService{
	private UsersMapper usersMapper; // 此类不用实例，在spring中配置了
	
	/**
	 * 	从spring容器中 取出值，再赋值给此类的属性。
	 * 	需要先在spring中配置 
	 * <context:component-scan base-package="com.wendao.service.impl"></context:component-scan>
	 */
	@Value("${my.demo}")
	private String test;

	@Value("${my.demo1}")
	private int test1;
	
	
	public UsersMapper getUsersMapper() {
		return usersMapper;
	}



	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}



	/**
	 * 	作为切点
	 */
	@Override
	public Users login(Users users) {
		System.out.println(" ============= \nUsersServiceImpl.login(), "
				+this.test+this.test1);
		return usersMapper.selByUsers(users);
	}

}
