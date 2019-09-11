package com.wendao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wendao.mapper.StudentMapper;
import com.wendao.mapper.TeacherMapper;
import com.wendao.pojo.Student;
import com.wendao.pojo.Teacher;

public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession ss = fac.openSession();
		
		TeacherMapper tm = ss.getMapper(TeacherMapper.class);
		StudentMapper sm = ss.getMapper(StudentMapper.class);
		
		// ================ 单表：查 ======================
//		List<Teacher> list = mapper.selAll();
//		for (Teacher teacher : list) {
//			System.out.println(teacher);
//		}
		
		// =================== 单表：增 =======================
//		int index = mapper.insTeacher(new Teacher(-1, "鬼谷子", null));
//		System.out.println(index);
		
		// =================== 单表：改 ===========================
//		int index = mapper.updTeacher(new Teacher(4, "无名", null));
//		System.out.println(index);
		
		// =================== 单表：删 =========================
//		int index = mapper.delById(4);
//		System.out.println(index);
		
		// ===================== 多表联合： ===============================
//		List<Student> list = sm.selAll();
//		for (Student student : list) {
//			System.out.println(student);
//		}
		
//		List<Teacher> list = tm.selTeacher();
		List<Teacher> list = tm.selAll2();
		for (Teacher teacher : list) {
			System.out.println(teacher);
		}
		
		
		ss.commit(); // 增删改 记得commit
		ss.close();
	}
}


















