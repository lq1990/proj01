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

import com.wendao.pojo.Log;
import com.wendao.pojo.PageInfo;
import com.wendao.service.LogService;

/**
 * 	LogServiceImpl提供给控制器：
 * 		方法：showPage().
 * 
 * 	每个service中公共部分：factory创建session，session commit close. 
 * 		把这些公共部分，放到filter中完成
 * @author china
 *
 */
public class LogServiceImpl implements LogService {

	@Override
	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		// session get
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession ss = fac.openSession();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageStart", (pageNumber-1)*pageSize);
		map.put("pageSize", pageSize);
		List<Log> list = ss.selectList("com.wendao.mapper.LogMapper.selByPage", map);
		long count = ss.selectOne("com.wendao.mapper.LogMapper.selCount");
		long total = (long) Math.ceil( (double)count/pageSize ); // 注意此处内层 的除法
		
		System.out.println("pageSize: "+pageSize+", count: "+count+", total: "+total);
		PageInfo pi = new PageInfo(pageSize, pageNumber, total, list);
		
		ss.commit();	
		ss.close();
		return pi;
	}

	
}
