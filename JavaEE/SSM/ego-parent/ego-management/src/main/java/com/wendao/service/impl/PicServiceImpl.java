package com.wendao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wendao.mapper.PicMapper;
import com.wendao.pojo.Pic;
import com.wendao.service.PicService;

@Service
public class PicServiceImpl implements PicService {

	@Resource
	private PicMapper picMapper;
	
	@Override
	public int insPic(Pic pic) {
		
		return picMapper.insPic(pic);
	}

	@Override
	public List<Pic> show() {
		return picMapper.selAll();
	}

	@Override
	public int delById(int id) {
		
		return picMapper.delById(id);
	}

	
	
}
