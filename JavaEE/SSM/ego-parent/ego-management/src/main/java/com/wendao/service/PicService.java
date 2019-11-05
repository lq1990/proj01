package com.wendao.service;

import java.util.List;

import com.wendao.pojo.Pic;

public interface PicService {

	int insPic(Pic pic);
	
	List<Pic> show();
	
	int delById(int id);
	
}
