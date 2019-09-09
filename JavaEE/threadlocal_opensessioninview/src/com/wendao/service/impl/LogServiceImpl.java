package com.wendao.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.wendao.mapper.LogMapper;
import com.wendao.pojo.Log;
import com.wendao.service.LogService;
import com.wendao.util.MyBatisUtil;

public class LogServiceImpl implements LogService {

	@Override
	public int ins(Log log) {
		SqlSession ss = MyBatisUtil.getSession();
		
		LogMapper mapper = ss.getMapper(LogMapper.class);
		
		return mapper.ins(log);
	}

}
