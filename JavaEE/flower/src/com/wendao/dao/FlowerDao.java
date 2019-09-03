package com.wendao.dao;

import java.util.List;

import com.wendao.pojo.Flower;

public interface FlowerDao {

	/**
	 * 	查询全部
	 */
	List<Flower> selAll();
	
	/**
	 * 	新增
	 * @param flower
	 * @return
	 */
	int insFlower(Flower flower);
	
	
	
}
