package com.wendao.dao;

import java.util.List;

import com.wendao.pojo.User;

public interface UserDao {
	
	/**
	 * 	根据用户名和密码查询用户信息
	 * @param uname 用户名
	 * @param pwd 密码
	 * @return 返回查询到的用户信息
	 */
	User checkUserLoginDao(String uname, String pwd);

	/**
	 * 	根据 uid修改用户的 密码
	 * @param newPwd
	 * @param uid
	 * @return
	 */
	int userChangePwdService(String newPwd, int uid);

	List<User> userShowDao();
	

	int userRegDao(User u);

	
	
	
}
