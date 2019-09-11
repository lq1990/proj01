package com.wendao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wendao.pojo.Student;

public interface StudentMapper {
	
	/**
	 * 	多表，联合查询的方式
	 * @return
	 */
	@Select("select s.id, s.name, age, tid, "
			+ "t.id `teacher.id`, t.name `teacher.name` "
			+ "from student s left join teacher t on t.id=s.tid")
	List<Student> selAll();
	
	@Select("select * from student where tid=#{0}")
	List<Student> selByTid(int tid);
	
}
