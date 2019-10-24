package com.wendao.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wendao.entity.User;
import com.wendao.entity.o2m.Classes;
import com.wendao.entity.o2m.Student;
import com.wendao.mapper.UserMapper;

public class TestOne2Many {
	static SqlSessionFactory fac;
	
	static {
		try {
			fac = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		new TestOne2Many().testSelectNPlus4Classes();
		
	}
	
	
	public void testSelectOnce4Students() {
		SqlSession ss = fac.openSession();
		
		List<Student> students = ss.selectList("com.wendao.mapper.One2Many.selectAllStudents");
		for (Student s : students) {
			System.out.println(s);
			System.out.println(s.getClasses());
		}
		
		ss.close();
		
	}
	
	public void testSelectNPlus4Classes() {
		SqlSession ss = fac.openSession();
		
		List<Classes> cls = ss.selectList("com.wendao.mapper.One2Many.selectAll");
		for (Classes c : cls) {
			System.out.println(c);
			
		}
		ss.close();
		
	}
	
	
	
	
}
