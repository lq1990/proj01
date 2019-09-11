package com.wendao.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wendao.mapper.AirplaneMapper;
import com.wendao.pojo.Airplane;
import com.wendao.service.AirplaneService;
import com.wendao.util.MyBatisUtil;

public class AirplaneServiceImpl implements AirplaneService{

	@Override
	public List<Airplane> show(int takeid, int landid) {
		SqlSession ss = MyBatisUtil.getSession();
		AirplaneMapper mapper = ss.getMapper(AirplaneMapper.class);
		
		return mapper.selByTakeidLandid(takeid, landid);
	}

}
