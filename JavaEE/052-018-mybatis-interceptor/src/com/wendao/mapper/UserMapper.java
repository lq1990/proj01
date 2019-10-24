package com.wendao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.wendao.entity.User;

public interface UserMapper {
	
	// 分页查询
	@Select("select id, name, age from t_user")
	public List<User> getUsers(@Param("page") int page, @Param("rows") int rows);
	
	
}
