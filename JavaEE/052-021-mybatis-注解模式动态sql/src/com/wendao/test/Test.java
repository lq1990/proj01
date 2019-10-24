package com.wendao.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wendao.entity.User;
import com.wendao.mapper.UserMapper;

public class Test {

	public static void main(String[] args) throws IOException {
		new Test().testInsertBatch();
		
		
		
		
	}
	
	public void testInsertBatch() {
		SqlSession ss = this.getSession();
		
		UserMapper mapper = ss.getMapper(UserMapper.class);
		
		Map<String, Object> params = new HashMap<String, Object>();
		List<User> list = new ArrayList<User>();
		list.add(new User(null, "beta", 1));
		list.add(new User(null, "cello", 11));
		params.put("users", list );
		
		int rows = mapper.batchInserUser(params);
		System.out.println("Test.testInsertBatch(), "+rows);
		
		ss.commit();
		ss.close();
		
	}
	
	public void testInsert() {
		SqlSession ss = this.getSession();
		
		UserMapper mapper = ss.getMapper(UserMapper.class);
		int rows = mapper.insertUser(new User((long) 11, "alex", 20));
		System.out.println(rows);
		
		ss.commit();
		ss.close();
	}
	
	
	private SqlSession getSession() {
		SqlSessionFactory fac = null;
		
		try {
			fac = 
				new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fac.openSession();
		
	}
	
	
}
