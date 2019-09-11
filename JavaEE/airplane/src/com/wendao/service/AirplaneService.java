package com.wendao.service;

import java.util.List;

import com.wendao.pojo.Airplane;

public interface AirplaneService {
	
	List<Airplane> show(int takeid, int landid);
	
	
}
