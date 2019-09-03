package com.wendao.service;

import java.util.List;

import com.wendao.pojo.Flower;

/**
 * 	Service中方法的命名 和业务功能一致。
 * 	区别于Dao中方法的命名和 db相关。
 * 
 * @author china
 *
 */
public interface FlowerService {
	
	/**
	 * 	显示所有花卉信息
	 * @return
	 */
	List<Flower> show();
	
	/**
	 * 	新增
	 * @param flower
	 * @return
	 */
	int add(Flower flower);
	
	
}
