package com.wendao.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.wendao.dao.UserDao;
import com.wendao.dao.impl.UserDaoImpl;
import com.wendao.pojo.User;
import com.wendao.service.UserService;

/**
 * log4j 日志应写在 servcie中。
 * @author china
 *
 */
public class UserServiceImpl implements UserService {
	// 声明日志对象
	Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	
	// 声明Dao层对象
	UserDao ud = new UserDaoImpl();

	@Override
	public User checkUserLoginService(String uname, String pwd) {
		// 打印日志
		logger.debug(uname+"发起登录请求");
		User u = ud.checkUserLoginDao(uname, pwd);
		
		if(u != null) {
			logger.debug(uname+"登录成功");
		} else {
			logger.debug(uname+"登录失败");
		}
		
		return u;
	}
	

	@Override
	public int userChangePwdService(String newPwd, int uid) {
		logger.debug(uid+":发起修改密码请求");
		int index = ud.userChangePwdService(newPwd, uid);
		
		if (index > 0) {
			logger.debug(uid+":密码修改成功");
		} else {
			logger.debug(uid+":密码修改失败");
		}
		
		return index;
	}


	@Override
	public List<User> userShowService() {
		List<User> lu = ud.userShowDao();
		logger.debug("显示所有用户信息："+lu);
		
		return lu;
	}


	@Override
	public int userRegService(User u) {
		int index = ud.userRegDao(u);
		
		return index;
	}
	
}




















