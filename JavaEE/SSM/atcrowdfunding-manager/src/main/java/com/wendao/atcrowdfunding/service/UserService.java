package com.wendao.atcrowdfunding.service;

import java.util.List;
import java.util.Map;

import com.wendao.atcrowdfunding.bean.User;

public interface UserService {

	public List<User> queryAll();

	public User query4Login(User user);

	public List<User> pageQuery(Map<String, Object> map);

	public int pageQueryCount(Map<String, Object> map);

	public void insertUser(User user);

	public User queryById(Integer id);

	public void updateUser(User user);

	public void deleteUserById(Integer id);

	public void deleteUsers(Map<String, Object> map);

	public void insertUserRoles(Map<String, Object> map);

	public void deleteUserRoles(Map<String, Object> map);

	public List<Integer> queryRoleidsByUserids(Integer id);
	
}
