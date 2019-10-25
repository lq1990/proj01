package com.wendao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wendao.mapper.UsersMapper;
import com.wendao.pojo.Users;
import com.wendao.service.UsersService;

/**
 * 	Serivce注解，将此类交给Spring管理
 * @author china
 *
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Resource
	private UsersMapper usersMapper;

	
	
	@Override
	public Users login(Users users) {
		
		return usersMapper.selByUsers(users);
	}
	
	
}
