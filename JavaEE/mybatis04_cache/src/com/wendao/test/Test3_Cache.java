package com.wendao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wendao.pojo.Log;


/**
 * 	缓存：
 * 		针对 查询，
 * 		先向cache中找，若有直接返回，若cache中没有才去db中找。		
 * 
 * @author china
 *
 */
public class Test3_Cache {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession ss = fac.openSession();
		List<Log> list = ss.selectList("com.wendao.mapper.LogMapper.selAll");
		ss.commit(); 
		// 即使设置了factory缓存<cache readOnly="true"></cache>， 若此ss不commit或close，内容不会放到factory换存中
		
		
		
		SqlSession ss2 = fac.openSession();
		List<Log> list2 = ss2.selectList("com.wendao.mapper.LogMapper.selAll");
//		System.out.println(list);
		ss2.close();
		
		/*
		 * 若多个session之间实现cache
		 * */
		
	}
}
