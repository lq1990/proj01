package com.wendao.mapper;

import java.util.List;

import com.wendao.pojo.PageInfo;
import com.wendao.pojo.Student;

public interface StudentMapper {
	
	List<Student> selByPage(PageInfo pi);
	
	/**
	 * 	nums of records
	 * @param pi
	 * @return
	 */
	long selCountByPageInfo(PageInfo pi);
	
	
}
