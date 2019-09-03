package com.wendao.service.impl;

import java.util.List;

import com.wendao.dao.FlowerDao;
import com.wendao.dao.impl.FlowerDaoImpl;
import com.wendao.pojo.Flower;
import com.wendao.service.FlowerService;

public class FlowerServiceImpl implements FlowerService {
	private FlowerDao flowerDao = new FlowerDaoImpl();
	
	@Override
	public List<Flower> show() {

		return flowerDao.selAll();
	}

	
	@Override
	public int add(Flower flower) {
		return flowerDao.insFlower(flower);
	}

}

