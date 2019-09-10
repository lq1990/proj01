package com.wendao.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wendao.mapper.StudentMapper;
import com.wendao.mapper.TeacherMapper;
import com.wendao.pojo.PageInfo;
import com.wendao.pojo.Student;
import com.wendao.pojo.Teacher;
import com.wendao.service.StudentService;
import com.wendao.util.MyBatisUtil;

public class StudentServiceImpl implements StudentService {

	@Override
	public PageInfo showPage(String sname, String tname, 
			String pageSizeStr, String pageNumberStr) {
		int pageSize = 2;
		int pageNumber = 1;
		if(pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		if(pageNumberStr != null && !pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		int pageStart = (pageNumber - 1) * pageSize;
		
		// session, mapper
		SqlSession ss = MyBatisUtil.getSession();
		StudentMapper stuMapper = ss.getMapper(StudentMapper.class);
		TeacherMapper teaMapper = ss.getMapper(TeacherMapper.class);
		

		PageInfo pi = new PageInfo();
		pi.setSname(sname);
		pi.setTname(tname);
		pi.setPageStart(pageStart);
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		List<Student> list = stuMapper.selByPage(pi);
		long count = stuMapper.selCountByPageInfo(pi);
		
		for (Student stu : list) {
			stu.setTeacher(teaMapper.selById(stu.getTid()));
		}
		
		long total = (long) Math.ceil((double)count/pageSize);
		pi.setList(list);
		pi.setTotal(total);
		
		return pi;
	}

}










