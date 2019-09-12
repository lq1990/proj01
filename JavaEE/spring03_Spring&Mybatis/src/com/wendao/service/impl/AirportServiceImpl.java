package com.wendao.service.impl;

import java.util.List;

import com.wendao.mapper.AirportMapper;
import com.wendao.pojo.Airport;
import com.wendao.service.AirportService;

public class AirportServiceImpl implements AirportService {
	private AirportMapper airportMapper;
	

	public AirportMapper getAirportMapper() {
		return airportMapper;
	}



	public void setAirportMapper(AirportMapper airportMapper) {
		this.airportMapper = airportMapper;
	}



	@Override
	public List<Airport> show() {
		
		return airportMapper.selAll();
		
		/**
		 * 之前：
		 * SqlSession ss = MyBatisUtil.getSession();
		 * m = ss.getMapper();
		 * m.selectAll();
		 */
	}

}
