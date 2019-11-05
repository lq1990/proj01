package com.wendao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wendao.mapper.PicMapper;
import com.wendao.pojo.Pic;
import com.wendao.service.PicService;

/**
 * 	在service中，通过使用注解Value，引到 properties中配置的
 * @author china
 *
 */
@Service
public class PicServiceImpl implements PicService{
	
	@Value("${management.url}")
	private String path;

	@Resource
	private PicMapper picMapper;

	@Override
	public List<Pic> show() {
		List<Pic> list = picMapper.selAll();
		for (Pic pic : list) {
			pic.setPath(path + pic.getPath());
		}
		
		return list;
	}

}
