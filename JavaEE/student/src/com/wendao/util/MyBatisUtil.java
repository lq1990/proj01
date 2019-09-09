package com.wendao.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 	工具类：
 * 		一个工厂
 * 		负责：session创建，commit，close		
 * 
 * 	借助：ThreadLocal
 * 
 * @author china
 *
 */
public class MyBatisUtil {
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	
	private static SqlSessionFactory factory = null;

	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 *  	此方法使得，同一个线程 无论在哪里取的ThreadLocal的值都是一致的。
	 * @return
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










