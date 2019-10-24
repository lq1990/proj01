package com.wendao.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wendao.entity.o2o.Person;

public class TestOne2One {
	static private SqlSessionFactory fac;
	
	static {
		try {
			fac = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TestOne2One().testAutoMapping();
		
	}
	
	public void testSelectNPlus() {
		
		SqlSession ss = fac.openSession();
		
		List<Person> ps = ss.selectList("com.wendao.mapper.One2One.selectPersons");
		
		for (Person p : ps) {
			System.out.println(p);
		}
		
		ss.close();
		
	}
	
	public void testSelectOnce() {
		SqlSession ss = fac.openSession();
		
		List<Person> ps = ss.selectList("com.wendao.mapper.One2One.selectAll");
		
		for (Person p : ps) {
			System.out.println(p);
		}
		
		ss.close();
		
	}
	
	public void testAutoMapping() {
		SqlSession ss = fac.openSession();
		
		List<Person> persons = ss.selectList("com.wendao.mapper.One2One.selectAllAutoMapping");
		
		for (Person p : persons) {
			System.out.println(p);
		}
		
		ss.close();
	}
	
	
}









