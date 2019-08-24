package com.wendao.service.impl;

import com.wendao.dao.LoginDao;
import com.wendao.dao.impl.LoginDaoImpl;
import com.wendao.pojo.User;
import com.wendao.service.LoginService;

/**
 * View -- LoginService -- LoginDao -- db
 * @author china
 *
 */
public class LoginServiceImpl implements LoginService {
	// 创建Dao层过渡
	LoginDao ld = new LoginDaoImpl(); // Dao操作db。
	
	
	@Override
	public User checkLoginService(String uname, String pwd) {
		
		return ld.checkLoginDao(uname, pwd);
	}

	
}
