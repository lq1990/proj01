package com.wendao.mapper;

import java.util.List;

import com.wendao.pojo.Menu;

public interface MenuMapper {
	
	List<Menu> selByPid(int pid);
	
}
