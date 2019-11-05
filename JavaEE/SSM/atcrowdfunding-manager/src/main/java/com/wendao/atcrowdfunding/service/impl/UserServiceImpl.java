package com.wendao.atcrowdfunding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendao.atcrowdfunding.bean.User;
import com.wendao.atcrowdfunding.dao.UserDao;
import com.wendao.atcrowdfunding.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	/**
	 * 	使用Autowired 自动装配
	 */
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
	}

	@Override
	public User query4Login(User user) {

		return userDao.query4Login(user);
	}
	
	
	
}
