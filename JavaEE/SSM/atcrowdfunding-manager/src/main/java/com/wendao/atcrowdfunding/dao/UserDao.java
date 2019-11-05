package com.wendao.atcrowdfunding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wendao.atcrowdfunding.bean.User;

public interface UserDao {

	@Select("select * from t_user")
	List<User> queryAll();

	@Select("select * from t_user where loginacct=#{loginacct} and pwd=#{pwd}")
	User query4Login(User user);

	
}
