package com.wendao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wendao.pojo.People;

public class TestLog4J {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = fac.openSession(); // openSession(true) 则默认 autoCommit
		
//		List<People> listb = session.selectList("com.wendao.PeopleMapper.fn1");
//		List<People> listb2 = session.selectList("com.wendao.PeopleMapper.fn2");
//		List<People> list = session.selectList("com.wendao.PeopleMapper2.fn1"); // pkg.class.fn
//		List<People> list2 = session.selectList("com.wendao.PeopleMapper2.fn2");
		// 在log4j.properties可配置 log4j.logger.pkg.class.fn=DEBUG，
		// 设置日志级别（包、类、方法）
		
		
		// 参数
//		People p = new People();
		
		// #{}, ${}
//		People p = new People();
//		List<People> list2 = session.selectList("a.b.sel1", p); 
//		
		
		// sql传入多个参时，借助map
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", 2);
//		map.put("name", "王也");
//		List<People> list = session.selectList("a.b.test", map); // 第二个参：sql中的参
		
		
		// mysql 分页
//		Map<String, Object> map2 = new HashMap<String, Object>();
//		int size = 3; // 显示几个
//		int num = 2;// 第几页
//		map2.put("pageSize", size);  
//		map2.put("pageStart", size*(num-1)); 
//		List<People> list2 = session.selectList("a.b.page", map2);
		
		
		// ============== 增 ======================================
		try {
			People p = new People();
			p.setName("司马也3");
			p.setAge(11);
			int index = session.insert("a.b.ins", p);
			if(index > 1) {
				System.out.println("success");
			} else {
				System.out.println("failed");
			}
			
		} catch (Exception e1) {
			session.rollback();
		}
		
		try {
			People p2 = new People();
			p2.setName("司马也32jjjjjdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			p2.setAge(12);
			int index2 = session.insert("a.b.ins", p2);
			if(index2 > 1) {
				System.out.println("success2");
			} else {
				System.out.println("failed2");
			}
			
		} catch (Exception e) {
			session.rollback(); // 事物回滚
		}
		
		
		System.out.println("----------result: ------------");
		
		session.commit(); // 增删改 后必须提交
		session.close();
		
	}
}













