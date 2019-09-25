package com.wendao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wendao.mapper.MenuMapper;
import com.wendao.pojo.Menu;
import com.wendao.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Resource
	private MenuMapper menuMapper;

	@Override
	public List<Menu> show() {
		return menuMapper.selByPid(0); // 由于是递归查询，从0层开始，所有层都出来了
	}

}
