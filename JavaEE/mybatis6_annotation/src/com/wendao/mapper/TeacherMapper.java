package com.wendao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wendao.pojo.Teacher;


/**
 * 	以注解 代替TeacherMapper.xml
 * 
 * @author china
 *
 */
public interface TeacherMapper {
	
	@Select("select * from teacher")
	List<Teacher> selAll();
	
	/**
	 * 	注解的括号中：#{name} name是teacher的属性
	 * @param teacher
	 * @return
	 */
	@Insert("insert into teacher values (default, #{name})")
	int insTeacher(Teacher teacher);
	
	
	@Update("update teacher set name=#{name} where id=#{id}")
	int updTeacher(Teacher teacher);
	
	@Delete("delete from teacher where id=#{0}")
	int delById(int id);
	
	
	
	/**
	 * N+1 方式，多表查询
	 * 	当涉及到 resultMap时，注解写起来麻烦
	 * 	Results 类比于resultMap
	 * 		Result 类比于 id/result
	 * 			many/one 类比于 collection/association
	 * @return
	 */
	@Results(value= 
		{
			@Result(id=true,property="id", column="id"),
			@Result(property="name", column="name"),
			@Result(property="list", column="id", 
				many=@Many(select="com.wendao.mapper.StudentMapper.selByTid"))
		}
	)
	@Select("select * from teacher")
	List<Teacher> selTeacher();
	
	
	List<Teacher> selAll2();
	
	
	
	
	
	
	
	
	
	
	
}
