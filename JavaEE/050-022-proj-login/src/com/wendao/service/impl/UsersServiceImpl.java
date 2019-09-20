package com.wendao.service.impl;

import com.wendao.mapper.UsersMapper;
import com.wendao.pojo.Users;
import com.wendao.service.UsersService;

public class UsersServiceImpl implements UsersService{
	private UsersMapper usersMapper; // 此类不用实例，在spring中配置了
	

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
		
		return usersMapper.selByUsers(users);
	}

}
