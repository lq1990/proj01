package com.wendao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wendao.mapper.FilesMapper;
import com.wendao.pojo.Files;
import com.wendao.pojo.Users;
import com.wendao.service.FilesService;

/**
 * 	Service中写业务逻辑、日志
 * @author china
 *
 */
@Service
public class FilesServiceImpl implements FilesService {
	private Logger logger = Logger.getLogger(FilesServiceImpl.class);

	@Resource
	private FilesMapper filesMapper;
	
	@Override
	public List<Files> show() {

		
		List<Files> list = filesMapper.selAll();
		return list;
	}

	@Override
	public int updCount(int id, Users users, String name) {
		logger.info(users.getUsername()+" 下载了 "+name);
		
		return filesMapper.updCountById(id);
	}

	
	
}
