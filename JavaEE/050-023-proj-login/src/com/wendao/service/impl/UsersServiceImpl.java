package com.wendao.service.impl;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendao.mapper.UsersMapper;
import com.wendao.pojo.Users;
import com.wendao.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	/**
	 *  配置了后，会自动去spring容器中找数据。
	 *  此类中不用写 get/set
	 */
	@Resource
	private UsersMapper usersMapper; // 此类不用实例，在spring中配置了
	


	/**
	 * 	作为切点
	 */
	@Override
	public Users login(Users users) {
		
		return usersMapper.selByUsers(users);
	}

}
