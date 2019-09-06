package com.wendao.service;

import java.io.IOException;

import com.wendao.pojo.PageInfo;

public interface LogService {
	
	/**
	 * 
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 * @throws IOException 
	 */
	PageInfo showPage(int pageSize, int pageNumber) throws IOException;
	
}
