package com.wendao.mapper;

import org.apache.ibatis.annotations.Select;

import com.wendao.pojo.Users;

public interface UsersMapper {
	
	@Select("select * from users "
			+ "where username=#{username} and password=#{password}")
	Users selByUsersPwd(Users u);
	
	
}
