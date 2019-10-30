package com.wendao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wendao.mapper.UsersMapper;
import com.wendao.pojo.Users;
import com.wendao.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Resource
	private UsersMapper usersMapper;

	public List<Users> show() {
		return usersMapper.selAll();
	}

	
}
