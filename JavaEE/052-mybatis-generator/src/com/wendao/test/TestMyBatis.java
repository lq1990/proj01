package com.wendao.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wendao.entity.Student;
import com.wendao.entity.StudentExample;
import com.wendao.entity.StudentExample.Criteria;
import com.wendao.mapper.StudentMapper;

/**
 * 	自动生成mybatis之后，测试
 * @author china
 *
 */
public class TestMyBatis {
	
	public static void main(String[] args) throws Exception {
		System.out.println("TestMyBatis.main()");
		new TestMyBatis().testSelect();
		
	}
	
	
	public void testInsert() throws Exception {
		SqlSession ss = this.getSession();
		StudentMapper mapper = ss.getMapper(StudentMapper.class);
		
		Student stu = new Student();
		stu.setAge(11);
		
		mapper.insertSelective(stu);// 新增参数中 非默认值数据字段 
		
		mapper.insert(stu);  // 新增参数中的 所有数据字段
		
		ss.commit();
		ss.close();
		
	}
	
	public void testDelete() throws Exception {
		SqlSession ss = this.getSession();
		
		StudentMapper mapper = ss.getMapper(StudentMapper.class);
		
		// 主键删除
		mapper.deleteByPrimaryKey(1);
		
		// 模拟Hibernate中的QBE定义的条件。Example类型。
//			每个实体对应一个Example, 每个Example中有一个Criteria内部类。
//			Criteria用于定义具体条件。note：约束只能做and多条件，所有的条件定义方式为：c.and字段名条件
//			e.g. c.andIdEqualTo  andNameLike  andIdBetween  andIdIn
		StudentExample example = new StudentExample();
		Criteria c = example.createCriteria();
		c.andIdEqualTo(2);
		c.andNameLike("%n%");
		
		// 根据example条件删除数据
		mapper.deleteByExample(example);
		
		ss.commit();
		ss.close();
		
	}
	
	
	public void testSelect() throws Exception {
		SqlSession ss = this.getSession();
		
		StudentMapper mapper = ss.getMapper(StudentMapper.class);
		// 主键查询
		Student stu = mapper.selectByPrimaryKey(2);
		System.out.println(stu);
		
		// 根据example条件查询多数据
		StudentExample example = new StudentExample();
		example.setOrderByClause("id desc limit 0,3"); // 排序
		example.setDistinct(true);
		
		Criteria c = example.createCriteria();
		c.andIdBetween(1, 5);
		c.andNameLike("_a%");
		List<Student> listStu = mapper.selectByExample(example);
		System.out.println(listStu);
		
		
		ss.commit();
		ss.close();
		
		
	}
	
	public void testUpdate() throws Exception {
		SqlSession ss = this.getSession();
		StudentMapper mapper = ss.getMapper(StudentMapper.class);
		
		Student stu = new Student();
		stu.setId(1);
		stu.setName("岚子");
		
		// 主键更新全部数据字段
		mapper.updateByPrimaryKey(stu);
		
		// 主键更新非默认值数据字段
		mapper.updateByPrimaryKeySelective(stu);
		
		StudentExample example = new StudentExample();
		Criteria c = example.createCriteria();
		c.andIdEqualTo(10);
		
		// 根据example条件更新全部数据字段
		mapper.updateByExample(stu, example);
		
		// 根据example条件更新非默认值数据字段
		mapper.updateByExampleSelective(stu, example);
		
		ss.commit();
		ss.close();
		
	}
	
	
	private SqlSession getSession() throws Exception {
		SqlSessionFactory fac = 
				new SqlSessionFactoryBuilder().build(
						Resources.getResourceAsStream("mybatis.xml"));
		
		return fac.openSession();
	}
}








