package com.wendao.service.impl;

import com.wendao.mapper.UsersMapper;
import com.wendao.pojo.Users;
import com.wendao.service.UsersService;

public class UsersServiceImpl implements UsersService {
	private UsersMapper usersMapper;

	// 设置属性的set get，因为 属性注入。在全局xml中配置
	public UsersMapper getUsersMapper() {
		return usersMapper;
	}

	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}
	
	
	
	
	@Override
	public Users login(Users u) {
		
		return usersMapper.selByUsersPwd(u);
	}
	

}
