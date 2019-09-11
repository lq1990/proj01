package com.wendao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wendao.pojo.Airport;

/**
 * 	使用注解
 * @author china
 *
 */
public interface AirportMapper {
	
	/**
	 * 	查询：哪些机场是 作为起飞机场
	 * @return
	 */
	@Select("select * from airport where id "
			+ "in (select distinct takeid from airplane)")
	List<Airport> selTakePort();
	
	
	@Select("select * from airport where id "
			+ "in (select distinct landid from airplane)")
	List<Airport> selLandPort();
	
}



