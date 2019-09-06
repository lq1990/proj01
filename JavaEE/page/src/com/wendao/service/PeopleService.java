package com.wendao.service;

import java.io.IOException;

import com.wendao.pojo.PageInfo;

/**
 * 
 * 	Service中写 业务逻辑
 * @author china
 *
 */
public interface PeopleService {
	
	/**
	 * 	分页显示
	 * @param pageSize 每一页多少记录
	 * @param pageNumber 第几页
	 * @return PageInfo存return的数据
	 * @throws IOException 
	 */
	PageInfo showPage(int pageSize, int pageNumber) throws IOException;
	
	
	
}
