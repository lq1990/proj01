package com.wendao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wendao.pojo.Pic;

public interface PicMapper {
	
	@Select("select * from pic")
	List<Pic> selAll();
	
}
