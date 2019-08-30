package com.wendao.serviceImpl;

import com.wendao.dao.UserDao;
import com.wendao.daoImpl.UserDaoImpl;
import com.wendao.pojo.User;
import com.wendao.service.UserService;

public class UserServiceImpl implements UserService {
	// 获取Dao层对象
	UserDao ud = new UserDaoImpl();

	@Override
	public User getUserInfo(String uname) {
		User u = ud.getUserInfo(uname);
		
		return u;
	}
	
	
}
