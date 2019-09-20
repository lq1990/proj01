package com.wendao.service.impl;

import com.wendao.pojo.Users;
import com.wendao.service.UsersService;

public class UsersServiceImpl implements UsersService {

	@Override
	public int insert(Users users) {
		
		return 0;
	}

	@Override
	public int insUsers(Users users) {
		System.out.println("insUsers, before insert");
		insert(users);
		System.out.println("insUsers, after insert");
		return 0;
	}
	
	public int updUsers(Users users) {
		return insert(users);
	}

}
