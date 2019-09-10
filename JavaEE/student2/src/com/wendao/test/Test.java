package com.wendao.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wendao.mapper.StudentMapper;
import com.wendao.pojo.PageInfo;
import com.wendao.pojo.Student;
import com.wendao.util.MyBatisUtil;

public class Test {
	
	
	public static void main(String[] args) {
		SqlSession session = MyBatisUtil.getSession();
		 StudentMapper stuMapper = session.getMapper(StudentMapper.class);
		 
		 PageInfo pi = new PageInfo();
		 pi.setPageNumber(1);
		 pi.setPageSize(4);
		 pi.setPageStart(1);
		 pi.setSname("");
		 pi.setTname("");
		 List<Student> list = stuMapper.selByPage(pi);
		 long count = stuMapper.selCountByPageInfo(pi);
		 
		 for (Student stu : list) {
			 System.out.println(stu);
		 }
		 
		 System.out.println("count: "+count);
		
	}
	
	
}

















