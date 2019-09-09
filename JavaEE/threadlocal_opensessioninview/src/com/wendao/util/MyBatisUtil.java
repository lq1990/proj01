package com.wendao.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 	此类中提供ThreadLocal对象，存储 factory session，
 * 	即线程专属，不会因为多线程乱套。
 * 
 * @author china
 *
 */
public class MyBatisUtil {
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	
	// factory 实例化的过程是一个 比较耗费性能的过程
	// 保证有且只有一个factory
	private static SqlSessionFactory factory; // 工厂会为每个线程生产session
	
	// 在类加载时就load
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 *  从工厂 获取SqlSession
	 */
	public static SqlSession getSession() {
		SqlSession session = tl.get();
		if(session == null) {
			tl.set(factory.openSession());
		}
		
		return tl.get();
	}
	
	public static void closeSession() {
		SqlSession ss = tl.get();
		if(ss != null) {
			ss.close();
		}
		
		tl.set(null);
	}
	
	
}








