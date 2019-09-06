package com.wendao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wendao.pojo.Log;

/**
 *  	 此接口的"实现类"：LogMapper.xml
 * @author china
 *
 */
public interface LogMapper {
	
	List<Log> selAll();
	
	/**
	 * 	使用注解的话，原理是传入的多个参数是放在map, @Param("key")
	 * @param accin
	 * @param accout
	 * @return
	 */
	List<Log> selByAccInAccOut(@Param("accin") String accin, @Param("accout") String accout);

	
	int upd(Log log);
	
	
	List<Log> selByLog(Log log);
	
	List<Log> selIn(List<Integer> list);
	
	List<Log> selUsingRef();
	
	Integer insMany(List<Integer> list);
	
}
