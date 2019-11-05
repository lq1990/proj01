package com.wendao.atcrowdfunding.service;

import java.util.List;

import com.wendao.atcrowdfunding.bean.User;

public interface UserService {

	public List<User> queryAll();

	public User query4Login(User user);
	
}
