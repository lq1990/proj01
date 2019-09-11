package com.wendao.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wendao.mapper.AirportMapper;
import com.wendao.pojo.Airport;
import com.wendao.service.AirportService;
import com.wendao.util.MyBatisUtil;

public class AirportServiceImpl implements AirportService {

	@Override
	public List<Airport> showTakePort() {
		SqlSession ss = MyBatisUtil.getSession();
		
		AirportMapper airportMapper = ss.getMapper(AirportMapper.class);
		List<Airport> list = airportMapper.selTakePort();
		
		return list;
	}

	@Override
	public List<Airport> showLandPort() {
		SqlSession ss = MyBatisUtil.getSession();
		
		AirportMapper airportMapper = ss.getMapper(AirportMapper.class);
		List<Airport> list = airportMapper.selLandPort();
		
		return list;
	}

	
	
}
