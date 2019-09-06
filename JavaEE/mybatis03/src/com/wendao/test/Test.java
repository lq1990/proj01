package com.wendao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wendao.mapper.LogMapper;
import com.wendao.pojo.Log;

public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession ss = fac.openSession();
		
		// ------------------ 接口绑定方案 --------------------------
		/**
		 * 	 接口，却实例化了
		 * 	
		 * 	需要给接口一个实例化对象
		 * 
		 * 	.getMapper() 使用JDK动态代理设计模式，
		 * 		面向接口的代理设计模式（必须有接口）
		 * 
		 * 
		 * 	优点：可以多参数传入sql
		 */
		LogMapper lm = ss.getMapper(LogMapper.class);
//		List<Log> list = lm.selAll();
//		for (Log log : list) {
//			System.out.println(log);
//		}
		
		// 对比之前的：单参数传递
//		ss.selectList("", ""); 
		
		// 实现多参数传递
		List<Log> lsit2 = lm.selByAccInAccOut("105", "101");
		for (Log log : lsit2) {
			System.out.println(log);
		}
		
		ss.close();
		
	}
}









