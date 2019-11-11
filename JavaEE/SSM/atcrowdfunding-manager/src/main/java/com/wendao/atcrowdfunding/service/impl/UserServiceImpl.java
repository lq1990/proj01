package com.wendao.atcrowdfunding.service.impl;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<User> pageQuery(Map<String, Object> map) {
		
		return userDao.pageQuery(map);
	}

	@Override
	public int pageQueryCount(Map<String, Object> map) {
		
		return userDao.pageQueryCount(map);
	}

	@Override
	public void insertUser(User user) {

		userDao.insertUser(user);
		
	}

	@Override
	public User queryById(Integer id) {

		return userDao.queryById(id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
		userDao.updateUser(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		userDao.deleteUserById(id);
		
	}

	@Override
	public void deleteUsers(Map<String, Object> map) {

		userDao.deleteUsers(map);
	}

	@Override
	public void insertUserRoles(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		userDao.insertUserRoles(map);
	}

	@Override
	public void deleteUserRoles(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		userDao.deleteUserRoles(map);
	}

	@Override
	public List<Integer> queryRoleidsByUserids(Integer id) {

		return userDao.queryRoleidsByUserids(id);
	}
	
	
	
}














