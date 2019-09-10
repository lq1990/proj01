package com.wendao.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wendao.mapper.StudentMapper;
import com.wendao.mapper.TeacherMapper;
import com.wendao.pojo.Student;
import com.wendao.pojo.Teacher;
import com.wendao.util.MyBatisUtil;

public class Test {
	public static void main(String[] args) {
		// 测试 mapper
		
		SqlSession ss = MyBatisUtil.getSession();
		TeacherMapper tMapper = ss.getMapper(TeacherMapper.class);
		StudentMapper stuMapper = ss.getMapper(StudentMapper.class);
		
		
		List<Teacher> list = tMapper.selAll2();
		
		for (Teacher teacher : list) {
			System.out.println(teacher);
		}
//		
//		List<Student> listStu = stuMapper.selAll2();
//		for (Student student : listStu) {
//			System.out.println(student);
//		}
		
		
		MyBatisUtil.closeSession();
		
	}
}











