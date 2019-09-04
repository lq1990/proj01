package com.wendao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.wendao.pojo.Flower;

/**
 * 	只是测试mybatis使用。
 * 	在ssm整合时，去掉test
 * @author china
 *
 */
public class TestMyBatis {
	static Logger logger = Logger.getLogger(TestMyBatis.class);
	
	public static void main(String[] args) {
		
		InputStream is = null;
		try {
			// 拿到配置db的资源
			is = Resources.getResourceAsStream("mybatis.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 使用工厂设计模式, 当生产过程复杂时使用 build模式
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		// 生产SqlSession
		SqlSession session = fac.openSession();
		
		// ----------- selectList ----------------
//		List<Flower> list = session.selectList("com.wendao.FlowerMapper.selAll"); // 包+类+方法
//		for (Flower f : list) {
//			System.out.println(f.toString());
//		}
		
		// ------------- selectOne --------------------
//		int count = session.selectOne("com.wendao.FlowerMapper.selById");
//		System.out.println("count: "+count);
		
		// ------------- selectmap -------------------
//		Map<Object, Object> map = session.selectMap("com.wendao.FlowerMapper.c", "name");
//		  // Map<"name", Flower>
//		System.out.println(map);
		
		
		// free
		session.close();
		
		
		
		
//		logger.debug("这是一个调试信息");
//		logger.info("这是一个info信息");
//		
//		
//		try {
//			int i = 5/0;
//		} catch (Exception e) {
////			e.printStackTrace();
//			logger.error(e.getMessage());
//		}
//		
//		System.out.println("over");
	}
}








