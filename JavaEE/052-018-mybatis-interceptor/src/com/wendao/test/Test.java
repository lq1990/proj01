package com.wendao.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wendao.entity.User;
import com.wendao.mapper.UserMapper;

public class Test {

	public static void main(String[] args) throws IOException {
		
		SqlSessionFactory fac = 
				new SqlSessionFactoryBuilder().build(
						Resources.getResourceAsStream("mybatis.xml"));
		
		SqlSession ss = fac.openSession();
		
		UserMapper mapper = ss.getMapper(UserMapper.class);
		
		
		List<User> list = mapper.getUsers(1, 2);
		
		System.out.println(list);
		
	}
}
