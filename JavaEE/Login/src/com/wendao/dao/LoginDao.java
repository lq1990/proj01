package com.wendao.dao;

import com.wendao.pojo.User;

public interface LoginDao {
	User checkLoginDao(String uname, String pwd);
}
