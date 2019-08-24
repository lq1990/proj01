package com.wendao.service;

import com.wendao.pojo.User;

public interface LoginService {
	User checkLoginService(String uname, String pwd);
}
