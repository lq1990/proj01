package com.wendao.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wendao.pojo.PageInfo;
import com.wendao.pojo.People;
import com.wendao.service.PeopleService;

public class PeopleServiceImpl implements PeopleService {

	@Override
	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		// session
	 	InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession ss = fac.openSession();

	 	// selByPage
		int pageStart = pageSize * (pageNumber - 1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		List<People> list = ss.selectList("com.wendao.mapper.PeopleMapper.selByPage", map);
		
		// selCount
		long count = ss.selectOne("com.wendao.mapper.PeopleMapper.selCount");
		
		PageInfo pi = new PageInfo();
		pi.setPageSize(pageSize);
		pi.setPageNumber(pageNumber);
		pi.setTotal((long) Math.ceil(count/pageSize));
		pi.setList(list);
		
		ss.close();
		
		return pi;
	}

}













