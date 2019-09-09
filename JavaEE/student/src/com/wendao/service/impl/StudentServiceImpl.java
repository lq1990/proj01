package com.wendao.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wendao.mapper.StudentMapper;
import com.wendao.mapper.TeacherMapper;
import com.wendao.pojo.PageInfo;
import com.wendao.pojo.Student;
import com.wendao.service.StudentService;
import com.wendao.util.MyBatisUtil;

/**
 * 	Service中写业务逻辑
 * @author china
 *
 */
public class StudentServiceImpl implements StudentService {

	@Override
	public PageInfo showPage(String sname, String tname, 
			String pageSizeStr, String pageNumberStr) {
		// set pageSize, pageNumber
		int pageSize = 2;
		int pageNumber = 1;
		if(pageSizeStr != null && !pageSizeStr.equals("") ) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		if(pageNumberStr != null && !pageNumberStr.equals("") ) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		// get session
		SqlSession ss = MyBatisUtil.getSession();
		StudentMapper stuMapper = ss.getMapper(StudentMapper.class);
		TeacherMapper teaMapper = ss.getMapper(TeacherMapper.class);
		
		
		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		pi.setPageStart((pageNumber-1)*pageSize);
		pi.setTname(tname);
		pi.setSname(sname);
		
		List<Student> list = stuMapper.selByPage(pi);
		// 查询出每个学生对应的老师信息
		for (Student student : list) {
			student.setTeacher(teaMapper.selById(student.getTid()));
		}
		// 此时，list中每个学生都有老师的信息
		
		pi.setList(list);
		
		long count = stuMapper.selCountByPageInfo(pi);
		long total = (long) Math.ceil(((double)count/pageSize));
		pi.setTotal(total);
		
		return pi;
	}

}













