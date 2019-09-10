package com.wendao.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 	工厂类，
 * 	为线程创建session，commit，close
 * 
 * 	借助于：ThreadLocal
 * 
 * @author china
 *
 */
public class MyBatisUtil {
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	
	private static SqlSessionFactory factory = null;
	
	static {
		try {
			InputStream is= Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static SqlSession getSession() {
		SqlSession session = tl.get();
		if(session == null) {
			tl.set(factory.openSession());
		}
		
		return tl.get();
	}
	
	public static void closeSession() {
		SqlSession session = tl.get();
		if(session != null) {
			session.close();
		}
		
		tl.set(null);
	}
	
	
}













